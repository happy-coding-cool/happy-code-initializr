var app = new Vue({
    el: '#app',
    data:{
        activeProject: "1",
        table: false,
        direction: 'rtl',
        dialogVisible: false,
        previewContent:'',
        filesTree: [],
        fileDetails: '', // 文件内容
        newZipFiles: '', // 解压之后的数据
        zipData: '', // blob数据
        editor: '',
        defaultExpandedKeys: [],
        tableData:[{
            tableName: 'h_user',
            tableDesc: '用户表'
          }, {
            tableName: 'h_org',
            tableDesc: '组织表'
          }, {
            tableName: 'h_post',
            tableDesc: '岗位表'
          }, {
            tableName: 'h_role',
            tableDesc: '角色表'
          }],
          happyCodeForm:{
              build: "maven",
              happyCodeVersion: "1.0.1.RELEASE",
              projectMetadata:{
                  group: "com.example",
                  artifact: "demo",
                  name: "demo",
                  proPackage : "com.example.demo",
                  description: "Demo project for Spring Boot",
                  javaVersion: "1.8"
              },
              author:{
                  name: "lanlanhappy",
                  email: "lanlanhappy@aliyun.com"
              },
              database:{
                  host: "localhost",
                  port: "3306",
                  username: "root",
                  password: "123456",
                  schema: "happy_admin",
                  tablePrefix: "h_",
                  tables:[]
              }
          }
    },
    methods:{

         listTables: function(){
            let that = this;
            this.table = true;
            axios.post('./happy-code/tables',
                this.happyCodeForm.database
            ).then(function(response) {
                if (response.data.resultCode === "0") {
                    that.tableData = response.data.data;
                }else{
                    that.errorNotify(response.data.resultCode, response.data.resultMessage);
                    that.tableData = []
                }
            }).catch(function(err) {
                console.log(err);
            })
         },

         handleSelectionChange: function(val){
            var tableSelected = new Array();
            for(i = 0; i < val.length; i++){
                tableSelected[i] = val[i].name;
            }
            this.happyCodeForm.database.tables = tableSelected;
         },

         startZip: function(){
            let that = this;
            this.downZipFile(this.happyCodeForm).then(function(response) {
                 if (response.data && response.data.resultCode
                        && response.data.resultCode !== "0") {
                     that.errorNotify(response.resultCode, response.resultMessage);
                 } else {
                     const {data, headers} = response;
                     const  fileName = headers['content-disposition']
                         .replace(/\w+;fileName=(.*)/,'$1');
                     that.handleFile(data, fileName, headers)
                 }
             }).catch(function(err) {
                 console.log(err);
             })
         },

         // 代码预览
         preview: function() {
             let that = this
             this.downZipFile(this.happyCodeForm).then(function(response) {
                 if (response.data && response.data.resultCode && response.data.resultCode !== "0") {
                     that.errorNotify(response.resultCode, response.resultMessage);
                 } else {
                     const {data} = response;
                     that.zipData = data
                     that.createTreeData()
                 }
             }).catch(function(err) {
                 console.log(err);
             })
         },
         // 创建目录树
         async createTreeData() {
             let newZip = new JSZip();
             const { files } = await newZip.loadAsync(this.zipData).catch(() => {
                 throw Error(`Could not load the ZIP project.`)
             })
             this.newZipFiles = files
             this.findRoot({ files })
         },

         // 查找目录树 并生成目录树 目前是只生成二级目录 后面的目录都采用实时获取
         findRoot(zip) {
             let that = this
             this.filesTree = []
             const dirKeys = Object.keys(zip.files)
             const root = Array.from(new Set(dirKeys.map(v => v.split('/')[0])))[0]
             this.filesTree.push({
                 isFolder: true,
                 path: root,
                 label: root,
                 children: []
             })
             const zipFileKeys = dirKeys.sort((a,b) => a.localeCompare(b))
             zipFileKeys.map((key, index) => {
                 const dirKeys = key.split('/')
                 let prevPath = dirKeys[0] + '/' + dirKeys[1]
                 const isExistDir = that.filesTree[0].children.filter(v => v.label === dirKeys[1])
                 const children = {
                     isFolder: dirKeys.length > 2,
                     path: prevPath,
                     label: dirKeys[1]
                 }
                 dirKeys.length > 2 && (children.children = [{label: null}])
                 if (isExistDir.length === 0) {
                     that.filesTree[0].children.push(children)
                 } else {
                     that.filesTree[0].children.concat(children)
                 }
             })
             const defaultData = this.filesTree[0].children.filter(v => !v.isFolder)[0]
             if (defaultData) {
                 this.currentFile = this.filesTree[0]
                 this.defaultExpandedKeys = [this.filesTree[0].label, defaultData.label]
                 this.getFilesDetails(defaultData)
             }
            this.dialogVisible = true;
         },
         // 获取文件内容
         getFilesDetails(data) {
             this.currentFile = data
             let that = this
             if (!data.isFolder) {
                 console.log("label:"+data.label)
                 var fileType = data.label.substring(data.label.lastIndexOf(".")+1, data.label.length);
                 if(fileType == "cmd" || fileType == "bat" || fileType == "jar"
                    || data.label == "mvnw" || data.label == "gradlew"
                    ){
                     return
                  }
                 this.newZipFiles[data.path].async('string').then(content => {
                     that.fileDetails = content
                     var modeType = 'text/x-java'
                     if(fileType === 'xml'){
                        modeType = 'xml'
                     }else if(fileType === 'md'){
                        modeType = 'markdown'
                     }else if(fileType === 'yml'){
                        modeType = 'yaml'
                     }

                     if(modeType === 'markdown'){
                         if (that.editor){
                             that.editor.setValue("")
                         }
                        this.$refs.previewMd.innerHTML = marked(content)
                        this.$refs.previewMd.style.display = "block"
                        document.querySelector('.CodeMirror').style.display="none";
                     }else{
                         if (that.editor) {
                              document.querySelector('.CodeMirror').style.display="block";
                              this.$refs.previewMd.style.display = "none"
                              that.editor.setOption("mode",modeType)
                              that.editor.setValue(content)
                          } else {
                             that.editor = CodeMirror.fromTextArea(this.$refs.textarea, {
                                    mode: modeType,
                                    lineNumbers: true,
                                    lint: true,
                                    lineWrapping: true,
                                    tabSize: 2,
                                    theme: '3024-day',
                                    readOnly: true
                                })
                              this.editor.setSize('auto', '600px')
                              that.editor.setValue(content)
                              this.$refs.previewMd.style.display = "none"
                           }
                         }
                 })
             }
         },
        handleNodeExpand(data) {
            if (data.isFolder) {
                const currentPath = data.path
                const dirKeys = Object.keys(this.newZipFiles)
                const targetFileKeys = dirKeys.filter(v => v.startsWith(currentPath))
                const children = []
                const baseLength = currentPath.split('/').length
                for (let i = 0; i < targetFileKeys.length; i++) {
                    const keys = targetFileKeys[i].split('/')
                    const isExistDir = children.filter(v => v.label === keys[baseLength])
                    if (isExistDir.length > 0) {
                        continue;
                    }
                    if (keys.length === baseLength + 1) {
                        console.log("label:"+keys[baseLength])
                        children.push({
                            isFolder: false,
                            path: currentPath + '/' + keys[baseLength],
                            label: keys[baseLength]
                        })
                    } else {
                        children.push({
                            isFolder: true,
                            path: currentPath + '/' + keys[baseLength],
                            label: keys[baseLength],
                            children: [{}]
                        })
                    }
                }
                this.$set(data, 'children', children);
            }
        },
         downZipFile(data) {
             return new Promise((resolve, reject) => {
                 axios.post('./happy-code/start',
                     data,
                     { responseType:'blob' }
                 ).then(function(response) {
                     resolve(response)
                 }).catch(err=> {
                     reject(err)
                 })
             })
         },

         handleFile(data, fileName, headers = { "content-type": 'text/plain;charset=utf-8' }) {
             const blob = new Blob([data],{
                 type: headers['content-type']
             });
             let dom = document.createElement('a');
             let url = window.URL.createObjectURL(blob);
             dom.href = url;
             dom.download = decodeURI(fileName);
             dom.style.display = 'none';
             document.body.appendChild(dom);
             dom.click();
             dom.parentNode.removeChild(dom);
             window.URL.revokeObjectURL(url);
         }


    }


})