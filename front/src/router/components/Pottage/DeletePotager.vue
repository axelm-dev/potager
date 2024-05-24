<template>
  <div>
    <h1>Supprimer un potager</h1>

    <h2>Liste des potagers existants</h2>
    <ul>
      <li v-for="pottage in pottages" :key="pottage.id">
        {{ pottage.name }} - {{ pottage.place }} - Surface : {{ pottage.surface }} m²
      </li>
    </ul>

    <form @submit.prevent="deletePottage">
      <div class="mb-3">
        <label for="pottageSelect" class="form-label">Sélectionner un potager à supprimer</label>
        <select class="form-control" id="pottageSelect" v-model="selectedPottageId">
          <option v-for="pottage in pottages" :key="pottage.id" :value="pottage.id">
            {{ pottage.name }} - {{ pottage.place }} - Surface : {{ pottage.surface }} m²
          </option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Supprimer</button>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const pottages = ref([]);
const selectedPottageId = ref(null);

const fetchPottages = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/pottage/getAll');
    pottages.value = response.data;
  } catch (error) {
    console.error('Erreur lors de la récupération des potagers:', error);
  }
};

const deletePottage = async () => {
  if (!selectedPottageId.value) {
    console.error('Aucun potager sélectionné');
    return;
  }

  try {
    await axios.post('http://localhost:8080/api/pottage/remove', { id: selectedPottageId.value });
    console.log('Potager supprimé avec succès');
    await fetchPottages();
  } catch (error) {
    console.error('Erreur lors de la suppression du potager:', error);
  }
};

onMounted(() => {
  fetchPottages();
});
</script>

<style scoped>
/* Ajoutez vos styles ici si nécessaire */
</style>
