<template>
  <div>
    <h1>Créer un potager</h1>
    <form @submit.prevent="createPottage">
      <div class="mb-3">
        <label for="name" class="form-label">Nom du potager</label>
        <input type="text" class="form-control" id="name" v-model="pottage.name">
      </div>
      <div class="mb-3">
        <label for="location" class="form-label">Localisation du potager</label>
        <input type="text" class="form-control" id="location" v-model="pottage.place">
      </div>
      <div class="mb-3">
        <label for="surface" class="form-label">Surface du potager</label>
        <input type="number" class="form-control" id="surface" v-model="pottage.surface">
      </div>
      <button type="submit" class="btn btn-primary">Créer</button>
    </form>
  <h2>Liste des potagers créés</h2>
  <ul>
    <li v-for="pottage in pottages" :key="pottage.id">
      {{ pottage.name }} - {{ pottage.place }} - Surface : {{ pottage.surface }} m²
    </li>
  </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      pottage: {
        name: '',
        place: '',
        surface: null
      },
      pottages: []
    }
  },
  mounted() {
    this.fetchPottages();
  },
  methods: {
    fetchPottages() {
      axios.post('http://localhost:8080/api/pottage/getAll')
          .then(response => {
            this.pottages = response.data;
          })
          .catch(error => {
            console.error('Erreur lors de la récupération des potagers:', error);
          });
    },
    createPottage() {
      axios.post('http://localhost:8080/api/pottage/create', this.pottage)
          .then(response => {
            console.log('Potager créé avec succès');
            this.fetchPottages();
          })
          .catch(error => {
            console.error('Erreur lors de la création du potager:', error);
          });
    }
  }
}
</script>
