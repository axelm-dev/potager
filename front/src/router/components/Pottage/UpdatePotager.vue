<template>
  <div>
    <h1>Mettre à jour un potager</h1>

    <h2>Liste des potagers existants</h2>
    <ul>
      <li v-for="pottage in pottages" :key="pottage.id">
        {{ pottage.name }} - {{ pottage.place }} - Surface : {{ pottage.surface }} m²
        <button @click="selectPottage(pottage)" class="btn btn-info btn-sm">Sélectionner</button>
      </li>
    </ul>

    <form @submit.prevent="updatePottage">
      <div class="mb-3">
        <label for="name" class="form-label">Nom du potager</label>
        <input type="text" class="form-control" id="name" v-model="selectedPottage.name">
      </div>
      <div class="mb-3">
        <label for="place" class="form-label">Localisation du potager</label>
        <input type="text" class="form-control" id="place" v-model="selectedPottage.place">
      </div>
      <div class="mb-3">
        <label for="surface" class="form-label">Surface du potager</label>
        <input type="number" class="form-control" id="surface" v-model="selectedPottage.surface">
      </div>
      <button type="submit" class="btn btn-primary">Mettre à jour</button>
    </form>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  setup() {
    const pottages = ref([]);
    const selectedPottage = ref({ name: '', place: '', surface: null });

    const fetchPottages = async () => {
      try {
        const response = await axios.post('http://localhost:8080/api/pottage/getAll');
        pottages.value = response.data;
      } catch (error) {
        console.error('Erreur lors de la récupération des potagers:', error);
      }
    };

    const selectPottage = (pottage) => {
      selectedPottage.value = { ...pottage };
    };

    const updatePottage = async () => {
      try {
        await axios.post('http://localhost:8080/api/pottage/update', selectedPottage.value);
        console.log('Potager mis à jour avec succès');
        fetchPottages();
      } catch (error) {
        console.error('Erreur lors de la mise à jour du potager:', error);
      }
    };

    onMounted(() => {
      fetchPottages();
    });

    return {
      pottages,
      selectedPottage,
      selectPottage,
      updatePottage
    };
  }
}
</script>

<style scoped>

</style>
