<template>
    <div>
<h1>글작성!</h1>
<div><label for="">b_id<input v-model="b_id" type="text" name="" id="bid" ></label></div>
<div><label for="">b_password<input v-model="b_password" type="password" name="" id="bpa"></label></div>
<br>
<div>
    <p>제목</p>
    <textarea v-model="title" name="" id="bti" style="width: 500px; height: 23px; resize: none;"></textarea></div>
    <p>내용</p>
<div><textarea v-model="text" name="" id="bte" style="width: 500px; height: 200px; resize: none;"></textarea></div>

<p id="btn" @click="insert()">작성!</p>


    </div>
   

</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import {useRouter} from 'vue-router';

const b_id = ref('ㅇㅇ');
const b_password = ref('1234');
const title = ref('');
const text = ref('');

const router = useRouter();

const insert = () =>{

    const data = {
        b_idd : b_id.value,
   b_passwordd : b_password.value,
  titled : title.value,
  textd : text.value,

    };

    console.log("c. 글작성버튼");

    console.log(`1. b_id = ${b_id.value}`);
    console.log(`2. b_password = ${b_password.value}`);
    console.log(`3. title = ${title.value}`);
    console.log(`4. text = ${text.value}`);

    // axios.post('http://localhost:8080/테이블명',data)
    //     .then(res => {
    //         console.log(res);
    //         alert('저장하였습니다.')


    // router.push({name:"home"});
    //     })
        router.push({name:"home"});

        // .catch(e => {
        //     console.log(e);
        //     alert('에러'+e.response.data.message);
        // })
} 

</script>

<style lang="scss" scoped>

</style>