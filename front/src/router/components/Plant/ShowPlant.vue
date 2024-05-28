<template>
  <div>
    <h1>Actions for {{ plant.name }}</h1>
    <ul>
      <li v-for="action in plant.actions" :key="action.id">{{ action.name }}</li>
    </ul>
    <button @click="showCreateActionForm = !showCreateActionForm" class="btn btn-primary">Créer une action</button>
    <div v-if="showCreateActionForm">
      <h2>Créer une nouvelle action</h2>
      <form @submit.prevent="createAction">
        <div class="form-group">
          <label for="actionName">Nom de l'action</label>
          <input type="text" id="actionName" v-model="newAction.name" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Créer</button>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const plant = ref({});
const showCreateActionForm = ref(false);
const newAction = ref({ name: '' });

onMounted(() => {
  axios.get(`http://localhost:8080/api/plant/${route.params.id}`)
      .then(response => {
        plant.value = response.data;
      })
      .catch(error => {
        console.error("There was an error fetching the plant data!", error);
      });
});

function createAction() {
  axios.post(`http://localhost:8080/api/plant/${plant.value.id}/action`, newAction.value)
      .then(response => {
        plant.value.actions.push(response.data);
        newAction.value.name = '';
        showCreateActionForm.value = false;
      })
      .catch(error => {
        console.error("There was an error creating the action!", error);
      });
}
</script>
