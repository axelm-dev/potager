<template>
  <div class="container">
    <h2>Modifier une Plante</h2>
    <form @submit.prevent="updatePlante">
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
      <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name : 'EditPlant',
  data() {
    return {
      plante: {
        id: '',
        name: '',
        type: '',
        variety: '',
        spaceUse: null
      }
    };
  },
  created() {
    const planteId = this.$route.params.id;
    axios.get(`http://localhost:8080/api/plant/get/${planteId}`)
        .then(response => {
          this.plante = response.data;
        })
        .catch(error => {
          console.error("Erreur lors de la récupération de la plante!", error);
        });
  },
  methods: {
    updatePlante() {
      const planteId = this.$route.params.id;
      axios.put(`http://localhost:8080/api/plant/update/${planteId}`, this.plante)
          .then(response => {
            alert('Plante modifiée avec succès!');
            this.$router.push('/');
          })
          .catch(error => {
            console.error("Erreur lors de la modification de la plante!", error);
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