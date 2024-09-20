

<template>


  <div style="background-color: aquamarine;">
<h1>-그린게시판-</h1>
<!-- <RouterLink to="/Home">글쓰기</RouterLink> -->


<!-- <RouterLink to="/App">메인</RouterLink> -->
<p id="btn" @click="main()">메인</p>
<p id="btn" @click="create()">글쓰기</p>


<RouterView />
  </div>
 
 
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'

import {useRouter} from 'vue-router';

const router = useRouter();


const main = () => {
  console.log("a. 메인버튼");
  router.push({name:"home"});
}

const create = ()=> {

  console.log("b. 글쓰기버튼");
  router.push({ name: "insert"});
}

</script>

<style lang="scss" scoped>


</style>