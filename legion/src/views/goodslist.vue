<template>
  <el-table :data = tableDate style="width: 75%">
    <el-table-column label="货物编号" prop="id"></el-table-column>
    <el-table-column label="名称" prop="name"></el-table-column>
    <el-table-column label="数量" prop="number"></el-table-column>
    <el-table-column label="单位" prop="units"></el-table-column>
    <el-table-column label="类型" prop="type"></el-table-column>
  </el-table>
</template>


<script>
import  {getGoods}  from "../api/api";
export default {
        data () {
            return {
                tableDate: []
            };
        },
       
        created () {
            this.getUserInfo();
        },
        watch: {

        },
        computed: {

        },
        methods: {
            getUserInfo () { //请求用户信息
              getGoods().then((response)=> {
                    this.tableDate = response.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            
        }
    }
</script>