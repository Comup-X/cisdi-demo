<template>
    <div id="app">
        <el-menu defaultActive="" theme="dark" class="el-menu-demo nav" mode="horizontal" :router="true">
            <el-menu-item index="1" :route="{path:'/show'}">查看数据</el-menu-item>
            <el-menu-item index="2" :route="{path:'/upload'}">上传数据</el-menu-item>
            <el-menu-item index="3" :route="{path:'/download'}">下载文件</el-menu-item>
        </el-menu>
        <transition>
            <router-view></router-view>
        </transition>
    </div>
</template>

<script>

    export default {
        data() {
            return {}
        },

        methods: {}
    }
</script>

<style>
    html, body {
        clear: both;
    }

    #app {
        font-family: Helvetica, sans-serif;
        text-align: center;
    }
</style>
