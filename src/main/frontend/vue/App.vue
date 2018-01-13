<template>
  <div id="app">
    <h1>{{ msg }}</h1>
    <p>List something here:</p>

    <ul id="pages">
      <li v-for="page in pages">
        {{ page.title }} : {{ page.content }}
      </li>
    </ul>
  </div>
</template>

<script>
  import axios from 'axios';


  export default {
    name: 'content',
    data() {
      return {
          msg:"BGJUG",
          pages: [],
          errors: []
        }
    },
    created() {
      axios.get(`/api/pages/`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.pages = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
