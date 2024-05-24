<template>
  <div class="container">
    <h2>Créer une Plante</h2>
    <form @submit.prevent="createPlante">
      <div class="mb-3">
        <label for="name" class="form-label">Nom</label>
        <input type="text" class="form-control" id="name" v-model="plante.name" required>
      </div>
      <div class="mb-3">
        <label for="type" class="form-label">Type</label>
        <input type="text" class="form-control" id="type" v-model="plante.type" required>
      </div>
      <div class="mb-3">
        <label for="variety" class="form-label">Variété</label>
        <input type="text" class="form-control" id="variety" v-model="plante.variety" required>
      </div>
      <div class="mb-3">
        <label for="spaceUse" class="form-label">Surface occupée (cm²)</label>
        <input type="number" class="form-control" id="spaceUse" v-model="plante.spaceUse" required>
      </div>
      <button type="submit" class="btn btn-primary">Créer</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      plante: {
        name: '',
        type: '',
        variety: '',
        spaceUse: null
      }
    };
  },
  methods: {
    createPlante() {
      axios.post('http://localhost:8080/api/plant/create', this.plante)
          .then(response => {
            alert('Plante créée avec succès!');
            this.$router.push('/');
          })
          .catch(error => {
            console.error("Erreur lors de la création de la plante!", error);
          });
    }
  }
}
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 1rem;
}
</style>