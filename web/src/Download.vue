<template>

    <div>
        <div v-for="file in files">
            <a :href="'http://127.0.0.1:8080/file/download?fileName='+encodeURI(file)">{{file}}</a>
        </div>
    </div>


</template>

<script>
    export default {
        data() {
            return {
                files: []
            }
        },

        created() {
            this.axios.get("/file").then(result => {
                this.files = result;
            })
        }
    }
</script>

<style scoped>

</style>