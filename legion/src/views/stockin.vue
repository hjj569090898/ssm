<template>
  <div>
    <el-input
      :placeholder="tip"
      v-model="Search.id"
      style="width: 280px;"
      class="filter-item"
      prefix-icon="el-icon-search"
      @keyup.enter.native="SeachClick(Search.id)"
    />

    <el-select v-model="value1" placeholder="全部" style="width: 200px" @change="HandleSearch">
      <el-option v-for="item in Selects" :key="item.value" :label="item.label" :value="item.value"></el-option>
    </el-select>
    <el-button type="success" round @click="ClickInsert()">添加入库申请</el-button>



      <el-table :data="StockIn" border style="width: 100%">
      <el-table-column prop="id" label="入库编号" width="140"></el-table-column>
      <el-table-column prop="goodsid" label="物品编码" width="140"></el-table-column>
      <el-table-column prop="name" label="物品名称" width="150"></el-table-column>
      <el-table-column prop="price" label="价格" width="110"></el-table-column>
      <el-table-column prop="num" label="数量" width="110"></el-table-column>
      <el-table-column prop="allprice" label="总价" width="110"></el-table-column>
      <el-table-column prop="number" label="当前库存" width="110"></el-table-column>
      <el-table-column prop="state" label="申请状态" width="110">
        <template slot-scope="scope">
          <span v-if="scope.row.state =='审核中'" style="color: #0000FF">{{ scope.row.state }}</span>
          <span v-else-if="scope.row.state =='申请失败'" style="color: red">{{ scope.row.state }}</span>
          <span v-else style="color: #37B328">{{ scope.row.state }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="applicant" label="申请人" width="130"></el-table-column>
      <el-table-column prop="date" label="申请时间" width="200"></el-table-column>
      <el-table-column prop="reason" label="申请原因" width="180"></el-table-column>
      <el-table-column label="操作" width="220">
        <template slot-scope="scope">
          <el-button @click="ClickList(scope.row)" type="text" size="medium" icon="el-icon-view">查看</el-button>
          <el-button
            @click="ClickUpdate(scope.row)"
            type="text"
            size="medium"
            icon="el-icon-edit-outline"
          >编辑</el-button>
          <el-button
            @click="ClickDelete(scope.row.in_id)"
            type="text"
            size="medium"
            icon="el-icon-delete"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  <el-dialog title="添加入库申请信息" :visible.sync="InsertFormVisible" :close-on-click-modal="true">
      <el-form :model="InsertForm" label-width="80px">
        
        <el-select v-model="value2"  placeholder="请选择入库物品类型" @change="handleTypeChange">
    <el-option
      v-for="item in SelectType"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
    
  </el-select>

  <el-select
    v-model="InsertForm.goodsid"
    style="margin-left: 20px;"
    placeholder="请选择入库物品" @change="handleIdChange">
    <el-option
      v-for="item in GoodsByType"
      :key="item.id"
      :label="item.id+  (item.name)"
      :value="item.id"
      >
    </el-option>
  </el-select>      
      <el-form-item label="当前库存">
          <el-input v-model="Stock.number" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="申请数量" >
          <el-input-number v-model="InsertForm.num"></el-input-number>
        </el-form-item>
        <el-form-item label="单价">
          <el-input-number v-model="InsertForm.price"></el-input-number>
        </el-form-item>
        <el-form-item label="总价">
          <el-input-number v-model="InsertForm.allprice"></el-input-number>
        </el-form-item>
        <el-form-item label="申请原因">
          <el-input type="textarea" v-model="InsertForm.reason"></el-input>
        </el-form-item>
        
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="InsertFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleInsert(InsertForm)">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="修改入库申请信息" :visible.sync="UpdateFormVisible" :close-on-click-modal="true">
      <el-form :model="UpdateForm" label-width="80px">
        <el-form-item label="入库编号">
          <el-input v-model="UpdateForm.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="商品编号">
          <el-input v-model="UpdateForm.goodsid" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="商品名称">
          <el-input v-model="UpdateForm.name" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="数量" >
          <el-input-number v-model="UpdateForm.num"></el-input-number>
        </el-form-item>
        <el-form-item label="单价">
          <el-input-number v-model="UpdateForm.price"></el-input-number>
        </el-form-item>
        <el-form-item label="总价">
          <el-input-number v-model="UpdateForm.allprice"></el-input-number>
        </el-form-item>
        <el-form-item label="申请人">
          <el-input type="textarea" v-model="UpdateForm.applicant" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="申请原因">
          <el-input type="textarea" v-model="UpdateForm.reason"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="UpdateFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="HandleUpdate(UpdateForm)">确 定</el-button>
      </div>
    </el-dialog>

    <div class="block">
      <span class="demonstration"></span>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        layout="total, prev, pager, next"
        :total="PageInfo.count"
      >
        <!-- data="tableData.slice((currentPage-1)pagesize,currentPagepagesize)"； -->
      </el-pagination>
    </div>
  </div>
</template>

<script>
import {
  StockIn,
  GetStockIn,
  SearchStockIn,
  StateStockIn,
  UpdateStockIn,
  DeleteStockIn,
  GoodsByType,
getGoods
} from "../api/api";
import { type } from "os";
import { error } from 'util';
import { URLSearchParams } from 'url';
export default {
  data() {
    return {
      Selects: [
        {
          value: "",
          label: "全部"
        },
        {
          value: "审核中",
          label: "审核中"
        },
        {
          value: "申请通过",
          label: "申请通过"
        },
        { value: "申请失败", label: "申请失败" }
      ],
      Stock:{
        number:0,
      },
      SelectType:[
        {
          value:"1",
          label:"材料"
        },
        {
          value:"2",
          label:"设备"
        }
      ],
      GoodsByType:[]
        ,
      UpdateForm: {
        id: "",
        goods: "",
        // goodsname:"",
        // now_num:"",
        num: 0,
        price: 0,
        allprice: 0,
        applicant:"" ,
        reason:"",
      },
      InsertForm:{
        goodsid:"",
        num :0,//申请数量
        price:0,
        allprice:0,
        applicant:"",
        state:"审核中",
        admin:"管理员",
        reason:"",
        date:"",
      },
      value1: "",
      value2: "",
      value3: "",
      chooseType:"",
      UpdateFormVisible: false,
      DeletedialogVisible: false,
      InsertFormVisible:false,
      update_id: "",
      Deleteid: "",
      currentPage: [],
      Search: {
        id: "",
        admin: ""
      },
      tip: "入库编号/物品编号/管理员",
      StockIn: [], //入库信息总数据
      PageInfo: [] //数据总数，上下个url
    };
  },
  created() {
    this.getList();
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  },
  methods: {
    getList() {
      this.currentPage = 1;
      this.Search.id = "";
      this.value1 = "";
      GetStockIn("",this.currentPage)
        .then(response => {
          this.StockIn = response.data;
          // this.PageInfo = response.data;
          this.PageInfo.count = 18;
        })
        .catch(function(error) {
          console.log(error);
        });
     
    },

    handleTypeChange:function(val)
    {
      this.chooseType =val;
      GoodsByType(this.chooseType).then(response =>{
        this.GoodsByType = response.data;
      })
      .catch(function(error) {
          console.log(error);
        });
    },
    handleIdChange:function(val)
    {
      this.InsertForm.applicant = localStorage.getItem("User");
      this.InsertForm.date = "2019-03-03 17:19:55.493733";
      console.log(this.InsertForm);
    },
    ClickInsert(){
      this.InsertFormVisible = true;
    },
    handleInsert(val)
    {
      // this.InsertForm = val;
      console.log(this.InsertForm);
      StockIn(this.InsertForm).then(response=>{
        this.InsertFormVisible = false;
        console.log(InsertForm);
        console.log("添加成功");
      }).catch(function(error){
        console.log(error);
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.Search.id = "";
      this.value1 = "";
      GetStockIn("",this.currentPage)
        .then(response => {
          this.StockIn = response.data;
          console.log(response.data); //请求正确时执行的代码
        })
        .catch(function(response) {
          console.log(response); //发生错误时执行的代码
        });
    },

    SeachClick(val) {
      this.search = val;
      if (this.search != "") {
        SearchStockIn(this.search)
          .then(response => {
            this.StockIn = response.data;
            console.log("查询成功");
          })
          .catch(function(response) {
            console.log(response); //发生错误时执行的代码
          });
      } else {
        this.currentPage = 1;
        this.Search.id = "";
        this.value1 = "";
        GetStockIn(this.currentPage, this.value1, this.Search.id)
          .then(response => {
            this.StockIn = response.data;
            this.PageInfo = response.data;
            console.log(currentPage);
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    },
    HandleSearch: function(value) {
      this.currentPage = 1;
      this.search = value;
      StateStockIn(this.search)
        .then(response => {
          this.StockIn = response.data;
          this.PageInfo = response.data;
          console.log("查询成功");
        })
        .catch(function(response) {
          console.log(response); //发生错误时执行的代码
        });
    },
    ClickUpdate(row) {
      this.UpdateFormVisible = true;
      this.UpdateForm = Object.assign({}, row);
    },
    HandleUpdate(val) {
      UpdateStockIn(val).then(res => {
        this.UpdateFormVisible = false;
        alert("修改成功！");
      });
    },

    ClickDelete(id) {
      this.$confirm("是否删除该条入库申请记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          DeleteStockIn(id)
            .then(response => {
              this.$message({
            type: "success",
            message: "删除成功!"
          });
            })
            .catch(function(error) {
              console.log(error);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    }
  }
};
</script>