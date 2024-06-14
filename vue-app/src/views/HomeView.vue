<template>
  <div class="home">
    <router-link to ="/user">사용자목록</router-link>
    <br/>
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
import axios from 'axios'
const uForm = {name:'테스트',email='test@email.com',pwd='1234',gender=true}
export default {
  name: 'HomeView',
  methods:{
    getData(){
      axios
      .post('http://localhost:8080/editById', uForm)
      .then((response) => {
        console.log(response)
      })
      .catch((error) => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>
a {
  color : black;
  text-decoration : none;
  font-weight :  bold;
  font-size : 1.5rem;
}
</style>
