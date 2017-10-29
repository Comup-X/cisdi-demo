<template>
    <div>
        <el-upload
                class="upload-demo"
                drag
                action="http://127.0.0.1:8080/index/importData"
                multiple>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        </el-upload>
    </div>
</template>

<script>
    export default {}
</script>

<style scoped>

</style>