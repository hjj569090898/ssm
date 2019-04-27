<template>
  <table
   
    border="1px" align="center" width="60%" height="70%"
  >
    <tr>
      <td>姓名</td>

      <td>
        <input type="text" disabled style="width:95%">
      </td>

    </tr>

    <tr>
      <td>手机号码</td>

      <td>
        <input type="tel" style="width:95%">
      </td>

      <td>电子邮箱</td>

      <td>
        <input type="email" style="width:95%">
      </td>
    </tr>

    <tr>
      <td>教育程度</td>

      <td>
        <input style="width: 95%; " type="text">
      </td>

      <td>工作职位</td>

      <td>
        <input style="width: 95%; " type="text">
      </td>
    </tr>

    <tr>
      <td>工作城市</td>

      <td>
        <input style="width: 95%; " type="text">
      </td>

      <td>期望工资</td>

      <td>
        <input style="width: 95%; " type="text">
      </td>
    </tr>

    <tr>
      <td>自我介绍</td>

      <td colspan="3">
        <input type="text" style="width: 98%; ">
      </td>
    </tr>

    <tr>
      <td>特长</td>

      <td colspan="3">
        <input type="text" style="width: 98%; ">
      </td>
    </tr>

    <tr>
      <td>家庭住址</td>

      <td colspan="3">
        <input type="text" style="width: 98%; ">
      </td>
    </tr>
  </table>
</template>

<script>
export default {
  data() {
    return {
      active: 0
    };
  },

  methods: {
    next() {
      if (this.active++ > 2) this.active = 0;
    }
  }
};
</script>