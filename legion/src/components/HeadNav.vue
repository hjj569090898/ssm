<template>
  <header class="head-nav">
    <el-row>
      <el-col :span="6" class="logo-container">
        <img src="../assets/logo.png" class="logo" alt>
        <span class="title">乐建建筑维修公司管理系统</span>
      </el-col>
      <el-col :span="6" class="user">
        <div class="userinfo">

          <img src="../assets/avatar.jpg" class ="avatar">
          <div class="welcome">
            <p class="name comename">欢迎您</p>
            <p class="name avatarname">{{username}}</p>
          </div>
          <span class="username">
            <el-dropdown trigger="click" @command="setDialogInfo">
              <span class="el-dropdown-link">
                <i class="el-icon-caret-bottom el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="info">个人信息</el-dropdown-item>
                <el-dropdown-item command="resetpw">密码修改</el-dropdown-item>
                <el-dropdown-item command="logout">退出</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </span>
        </div>
      </el-col>
    </el-row>
  </header>
</template>
<script>
// import { getuserInfo } from "../api/api";
import store from "../axios/index.js"
export default {
  name: "head-nav",
  data() {
    return {
     username : "",
     avatar:""
    };
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  },
  created() {
    // this.UserInfo();
    this.username = localStorage.getItem("User")
  },
  methods: {
    setDialogInfo(cmditem) {
      if (!cmditem) {
        console.log("test");
        this.$message("菜单选项缺少command属性");
        return;
      }
      switch (cmditem) {
        case "info":
          this.showInfoList();
          break;
        case "logout":
          this.logout();
          break;
        case "resetpw":
          this.resetpw();
          break;
      }
    },

    handleFile: function(e) {
      let $target = e.target || e.srcElement;
      let file = $target.files[0];
      var reader = new FileReader();
      reader.onload = data => {
        let res = data.target || data.srcElement;
        this.userInfo.avatar = res.result;
      };
      reader.readAsDataURL(file);
    },
    // UserInfo() {
    //   getuserInfo().then(response => {
    //     this.UserInfo1 = response.data;
    //   });
    // },
    showInfoList() {
      // 个人信息
      this.$router.push("/infoshow");
    },
    resetpw() {
      // 密码重置
      this.$router.push("/resetpw");
    },

    logout() {
      // 清除token
      localStorage.removeItem("eleToken");
      localStorage.removeItem("User");
      this.$store.dispatch("clearCurrentState");

      // 页面跳转
      this.$router.push("/login");
    }
  }
};
</script>

<style scoped>
.head-nav {
  width: 100%;
  height: 80px;
  min-width: 600px;
  padding: 5px;
  background: #324056;
  color: #fff;
  border-bottom: 2px solid #1f2d3d;
}
.logo-container {
  line-height: 60px;
  min-width: 300px;
}
.logo {
  height: 91px;
  width: 100px;
  margin-right: 5px;
  margin-left: -6px;
  margin-top: -5px;
  vertical-align: middle;
  display: inline-block;
}
.title {
  vertical-align: middle;
  font-size: 22px;
  font-family: "Microsoft YaHei";
  letter-spacing: 4px;
}
.user {
  line-height: 60px;
  text-align: right;
  float: right;
  padding-right: 10px;
}
.avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  vertical-align: middle;
  display: inline-block;
}
.welcome {
  display: inline-block;
  width: auto;
  vertical-align: middle;
  padding: 0 5px;
}
.name {
  line-height: 20px;
  text-align: center;
  font-size: 17px;
}
.comename {
  font-size: 12px;
}
.avatarname {
  color: #409eff;
  font-weight: bolder;
}
.username {
  cursor: pointer;
  margin-right: 5px;
}
.el-dropdown {
  color: #fff;
}
</style>
