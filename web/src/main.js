import Vue from 'vue'
import ElementUI from 'element-ui'
import VueRouter from 'vue-router';
import 'element-ui/lib/theme-default/index.css'
import App from './App.vue'

import routes from './routes';
import axios from 'axios';

//使用VueRouter前端路由
Vue.use(VueRouter);
//使用ElementUI界面框架
Vue.use(ElementUI);

//设置后台基础IP地址
axios.defaults.baseURL = "http://127.0.0.1:8080";
//全局响应预处理
axios.interceptors.response.use(function (response) {
    if (response.data.code !== 0) {
        v.$alert(response.data.message, 'Error', {
            confirmButtonText: '确定',
        });
        // return Promise.reject(response);
    } else {
        return response.data.data;
    }
}, function (error) {
    v.$message({
        type: 'error',
        message: error.message
    });
    //return Promise.reject(error);这行代码触发axios的catch方法
});

//添加axios到Vue全局变量中
Vue.prototype.axios = axios;

//设置路由
const router = new VueRouter({routes});

//挂载Vue到index.html中id=app的div中
let v = new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
