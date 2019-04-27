<template>
    <div class="login">
        <section class="form_container">
            <div class="manage_tip">
                <span class="title">乐建建筑维修工程管理系统</span>
            </div>
            <el-form :model="loginUser" :rules="rules" ref="loginForm" class="loginForm" label-width="60px">
                <el-form-item label="工号" prop="username">
                    <el-input v-model="loginUser.username" placeholder="请输入工号/手机号"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="loginUser.password" placeholder="请输入密码" type="password"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary"  @click="submitForm('loginForm')" class="submit_btn">登  录</el-button>
                </el-form-item>
               
            </el-form>
        </section>
    </div>
</template>

<script>
import jwt_decode from "jwt-decode";
import { login } from '../api/api'
export default {   
  name: "login",
  data() {
    return {
      loginUser: {
        username: "",
        password: ""
      },
      rules: {
        username: [
          {
            // type: "email",
            required: true,
            message: "用户名格式不正确",
            trigger: "change"
          }
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" },
          { min: 6, max: 30, message: "长度在 6 到 30 个字符", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          login(this.loginUser).then(res => {
        
            const { token } = res.data.jwt;
            const {User} =res.data.User;
         
            localStorage.setItem("eleToken",res.data.jwt);
            localStorage.setItem("User",res.data.User);
            
            // 存储数据
            this.$store.dispatch("setIsAutnenticated", !this.isEmpty(token));
            this.$store.dispatch("setUser", User);

            // 页面跳转
            this.$router.push("/index");
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    isEmpty(value) {
      return (
        value === undefined ||
        value === null ||
        (typeof value === "object" && Object.keys(value).length === 0) ||
        (typeof value === "string" && value.trim().length === 0)
      );
    },
  }
};
</script>

<style scoped>
.login {
  position: relative;
  width: 100%;
  height: 58rem;
  background: url(../assets/bg.png) no-repeat center center;
  background-size: 100% 100%;
}
.form_container {
  width: 370px;
  height: 210px;
  position: absolute;
  top: 20%;
  left: 39%;
  padding: 25px;
  border-radius: 5px;
  text-align: center;
}
.form_container .manage_tip .title {
  font-family: "Microsoft YaHei";
  font-weight: bold;
  font-size: 30px;
  color: rgb(7, 6, 6);
}
.loginForm {
  margin-top: 20px;
  background-color: #fff;
  padding: 20px 40px 20px 20px;
  border-radius: 5px;
  box-shadow: 0px 5px 10px #cccc;
}

.submit_btn {
  width: 100%;
}
.tiparea {
  text-align: right;
  font-size: 12px;
  color: #333;
}
.tiparea p a {
  color: #409eff;
}
</style>


