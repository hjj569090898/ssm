import axios from 'axios'
import { Message, Loading } from 'element-ui';
import router from '../router/index'
// import login from '../views/Login'

var localStorage=window.localStorage

let loading        //定义loading变量

function startLoading() {    //使用Element loading-start 方法
    loading = Loading.service({
        lock: true,
        text: '加载中...',
        background: 'rgba(0, 0, 0, 0.7)'
    })
}
function endLoading() {    //使用Element loading-close 方法
    loading.close()
}

// 请求拦截  设置统一header
axios.interceptors.request.use(config => {
    // 加载
    startLoading()
    // endLoading()
    if (localStorage!=null)
        // config.headers.Authorization = JSON.parse(localStorage.getItem('eleToken'))
        // config.headers.Authorization = localStorage.getItem('eleToken')      
        //    config.headers= "Access-Control-Allow-Origin: *";
        config.headers.Authorization = localStorage.getItem('eleToken');
        console.log(localStorage.getItem('eleToken'));
    return config
}, error => {
    return Promise.reject(error)
})

// 响应拦截  401 无权限处理
axios.interceptors.response.use(response => {
    endLoading()
    return response
}, error => {
    // 错误提醒
    endLoading()
    // Message.error(error.response.data)

    const { status } = error.response
    if (status == 401) {
        Message.error('抱歉，您没有权限查看')
    //     // 清除token
    //     localStorage.removeItem('eleToken')

    //     // 页面跳转
        router.go(-1)
    } else if(status == 400)
    {
        Message.error('抱歉，您的请求存在错误')
    }

    return Promise.reject(error)
})

export default axios