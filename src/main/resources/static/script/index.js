var app = new Vue({
    el: '#app',
    data:{
        activeProject: "1",
        table: false,
        direction: 'rtl',
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
                  schema: "happy-demo",
                  tablePrefix: "h_"
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
                console.log("options: ", that.options);
            }).catch(function(err) {
                console.log(err);
            })
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
         },
    }


})