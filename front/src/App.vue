<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavbarComponent from "@/components/NavbarComponent.vue";
</script>

<template>
  <div>
    <NavbarComponent />
    <router-view />
  </div>
</template>

