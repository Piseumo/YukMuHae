<template>
  <div id="app">
    <header>
      <div class="title">
        <img src="@/assets/logo.png" alt="logo" class="logo" />
        <h1>grynworld</h1>
      </div>
    </header>
    <main>
      <BoardList />
    </main>
  </div>
</template>

<script>
import BoardList from './components/BoardList.vue'
import './assets/main.css'

export default {
  name: 'App',
  components: {
    BoardList
  }
}
</script>