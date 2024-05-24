<script setup>
import { RouterView } from 'vue-router'
import NavbarComponent from "@/components/NavbarComponent.vue";
</script>

<template>
  <div id="app">
    <header>
      <NavbarComponent />
    </header>
    <main>
      <RouterView />
    </main>
    <footer>
      @PottagePower 2024
    </footer>
  </div>
</template>

<style scoped>
#app {
  display: grid;
  grid-template-rows: auto 1fr auto;
  min-height: 100vh;
  grid-template-areas:
    "header"
    "main"
    "footer";
}

header {
  grid-area: header;
  color: white;
  padding: 1rem;
}

main {
  grid-area: main;
  padding: 1rem;
}

footer {
  grid-area: footer;
  background-color: #333;
  color: white;
  text-align: center;
  padding: 1rem;
}

@media (max-width: 600px) {
  header, footer {
    text-align: center;
    padding: 0.5rem;
  }

  main {
    padding: 0.5rem;
  }
}
</style>
