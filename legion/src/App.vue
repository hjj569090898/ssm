<template>
    <div id="app">
        <!--这里是全局视图层-->
        <router-view></router-view>
    </div>
</template>
<script>
import jwt_decode from "jwt-decode";
export default {
  name: "app",
  created() {
    if (localStorage.eleToken) {
      const decode = jwt_decode(localStorage.eleToken);
      this.$store.dispatch("setIsAutnenticated", !this.isEmpty(decode));
      this.$store.dispatch("setUser", decode);
    }
  },
  mounted() {
          window.onbeforeunload = function (e){
             localStorage.removeItem('eleToken');
          }
  },
  methods: {
    isEmpty(value) {
      return (
        value === undefined ||
        value === null ||
        (typeof value === "object" && Object.keys(value).length === 0) ||
        (typeof value === "string" && value.trim().length === 0)
      );
    }
  }
};
</script>
<style>

</style>
