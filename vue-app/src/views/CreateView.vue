<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 등록</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" autocomplete="off" :class="{active:active.name}" v-model="result.name"/>
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" autocomplete="off" :class="{active:active.email}" v-model="result.email"/>
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" autocomplete="off" :class="{active:active.pwd}" v-model="result.pwd"/>
      </div>
      <div class="d-flex">
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" checked v-model="result.gender" v-bind:value="true"/>
            <label class="form-check-label" for="radio1">남성</label>
          </div>
        </div>
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="gender" v-model="result.gender" v-bind:value="false"/>
            <label class="form-check-label" for="radio2">여성</label>
          </div>
        </div>
      </div>
    </form>
    <div class="d-flex">
      <div class="p-2 flex-fill d-grid">
        <button class="btn btn-primary" v-on:click="save()">생성</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <router-link to="/user" class="btn btn-primary">취소</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import store from '@/store'
export default{
  name : 'ListView',
  data(){
    return {
      result : {name:'', email: '', pwd:'', gender: true},
      active : {name:false,email:false,pwd:false}
    }
  },
  methods:{
    save(){
      if(this.result.name == ''){
        console.log('사용자 이름을 입력해주세요');
        this.active.name = true;
        return 
      }else{
        this.active.name = false;
      }
      if(this.result.email == ''){
        console.log('사용자 이메일을 입력해주세요');
        this.active.email = true;
        return 
      }else{
        this.active.email = false;
      }
      if(this.result.pwd == ''){
        console.log('사용자 비밀번호를 입력해주세요');
        this.active.pwd = true;
        return 
      }else{
        this.active.pwd = false;
      }
      console.log(this.result)

      axios
      .put(process.env.VUE_APP_BASEURL + '/save',this.result)
      .then((res)=>{
        console.log(res);
        this.$store.commit('setUser',res.data.result);
        sessionStorage.setItem('setUser',JSON.stringify(res.data.result))
        this.$router.push({name:'ListView'})
      })
      .catch((err) => console.log(err))
    }
  }
}
</script>

<style scoped>
  .active{
    background: red;
  }
</style>