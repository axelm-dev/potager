<script setup>

import {onMounted, ref} from 'vue';
import axios from "axios";

const actions = ref([]);

onMounted(() => {
  axios.get('http://localhost:8080/api/action/getAll')
      .then(response => {
        actions.value = response.data;
      })
      .catch(error => {
        console.error("There was an error!", error);
      });
});

</script>

<template>
  <div class="container">
    <h1>Actions</h1>
    <!-- Button Filtre sur la date 2 semaines - 3 semaines -->
    <div class="d-inline-flex">
      <button class="btn btn-primary m-2">2 semaines</button>
      <button class="btn btn-primary m-2">3 semaines</button>
    </div>
    <div class="row">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Date</th>
            <th>Event</th>
            <th>Place</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="action in actions" :key="action.id">
            <td>{{ action.date }}</td>
            <td>{{ action.event }}</td>
            <td>{{ action.place }}</td>
          </tr>
        </tbody>
      </table>
      </div>
  </div>
</template>

<style scoped>

</style>