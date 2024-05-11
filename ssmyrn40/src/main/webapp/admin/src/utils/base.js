const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmyrn40/",
            name: "ssmyrn40",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmyrn40/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "会议发布与预约系统小程序"
        } 
    }
}
export default base
