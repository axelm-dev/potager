<template>
  <div class="container">
    <h2>Liste des potagers créés</h2>
    <ul>
      <li v-for="pottage in pottages" :key="pottage.id">
        {{ pottage.name }} - {{ pottage.place }} - {{ pottage.city }} - Surface : {{ pottage.surface }} m²
      </li>
    </ul>
    <h1>Créer un potager</h1>
    <form @submit.prevent="createPottage">
      <div class="mb-3">
        <label for="name" class="form-label">Nom du potager</label>
        <input type="text" class="form-control" id="name" v-model="pottage.name">
      </div>
      <div class="mb-3">
        <label for="location" class="form-label">Adresse</label>
        <input type="text" class="form-control" id="location" v-model="pottage.place">
      </div>
      <div class="mb-3">
        <label for="location" class="form-label">Ville</label>
        <input type="text" class="form-control" id="location" v-model="pottage.city">
      </div>
      <div class="mb-3">
        <label for="surface" class="form-label">Surface du potager</label>
        <input type="number" class="form-control" id="surface" v-model="pottage.surface">
      </div>
      <button type="submit" class="btn btn-primary">Créer</button>
    </form>
  </div>
</template>

<script setup>
import {ref, onMounted, watch, defineEmits, defineProps} from 'vue';
import axios from 'axios';

const pottage = ref({name: '', place: '', city:'', surface: null});
const pottages = ref([]);
const emits = defineEmits(['pottageCreated']);

const props = defineProps({
  updatedPottage: {
    type: Object,
    default: null,
  },
  deletedPottageId: {
    type: [String, Number],
    default: null,
  },
});

const fetchPottages = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/pottage/getAll');
    pottages.value = response.data;
  } catch (error) {
    console.error('Erreur lors de la récupération des potagers:', error);
  }
};

const createPottage = async () => {
  try {
    await axios.post('http://localhost:8080/api/pottage/create', pottage.value);
    console.log('Potager créé avec succès', pottage.value);
    emits('pottageCreated', pottage.value);
    fetchPottages();
  } catch (error) {
    console.error('Erreur lors de la création du potager:', error);
  }
};

onMounted(() => {
  fetchPottages();
});

watch(() => props.updatedPottage, (newValue) => {
  if (newValue) {
    fetchPottages();
  }
});

watch(() => props.deletedPottageId, (newValue) => {
  if (newValue) {
    fetchPottages();
  }
});
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 1rem;
}
</style>
