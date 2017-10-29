<template>
    <div>
        <el-table
                :data="pageData.content"
                style="width: 100%"
                border>
            <el-table-column
                    class=""
                    prop="A1"
                    label="A1">
            </el-table-column>
            <el-table-column
                    prop="A2"
                    label="A2">
            </el-table-column>
            <el-table-column
                    prop="A3"
                    label="A3">
            </el-table-column>
            <el-table-column
                    prop="A4"
                    label="A4">
            </el-table-column>
            <el-table-column
                    prop="A5"
                    label="A5">
            </el-table-column>
            <el-table-column
                    prop="A6"
                    label="A6">
            </el-table-column>
            <el-table-column
                    prop="A7"
                    label="A7">
            </el-table-column>
            <el-table-column
                    prop="A8"
                    label="A8">
            </el-table-column>
            <el-table-column
                    prop="A9"
                    label="A9">
            </el-table-column>
            <el-table-column
                    prop="A10"
                    label="A10">
            </el-table-column>
            <el-table-column
                    prop="A11"
                    label="A11">
            </el-table-column>
            <el-table-column
                    prop="A12"
                    label="A12">
            </el-table-column>
            <el-table-column
                    prop="Quality"
                    label="Quality">
            </el-table-column>
        </el-table>
        <div class="block btm">
            <el-pagination
                    layout="prev, pager, next"
                    :page-count="pageData.totalPages"
                    @current-change="handleCurrentChange">
            </el-pagination>
        </div>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                pageData: {}
            }
        },

        methods: {
            handleCurrentChange(pageNumber) {
                console.log(pageNumber);
                this.getData(pageNumber, 20);
            },

            getData(pageNumber, pageSize) {
                this.axios.get("/index/getData", {
                    params: {
                        pageNumber: pageNumber,
                        pageSize: pageSize
                    }
                }).then(data => {
                    this.pageData = data;
                    console.log(data.totalPages);
                    console.log(data.totalElements);
                })
            }
        },

        created() {
            this.getData(1, 20);
        }
    }
</script>

<style scoped>
    .btm {
        position: absolute;
        left: 0;
        right: 0;
        bottom: 0;
    }
</style>