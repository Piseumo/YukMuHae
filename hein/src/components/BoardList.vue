<template>
    <div class="board-list">
      <h2>글 목록</h2>
      <ul>
        <li v-for="post in posts" :key="post.id">
          {{ post.title }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        posts: [
          { id: 1, title: '첫 번째 게시글' },
          { id: 2, title: '두 번째 게시글' },
          { id: 3, title: '세 번째 게시글' },
          { id: 4, title: '네 번째 게시글' },
        ]
      }
    }
  }
  </script>