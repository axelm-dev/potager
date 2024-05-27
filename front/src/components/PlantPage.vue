<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";
import cannabisLeafImage from "@/assets/cannabis.png";
import mushroomImage from "@/assets/mushroom.png";
import EditPlant from "@/router/components/Plant/EditPlant.vue";

// Initialiser variable plantes
const plantes = ref([]);

onMounted(() => {
  axios.get('http://localhost:8080/api/plant/getAll')
      .then(response => {
        plantes.value = response.data;
      })
      .catch(error => {
        console.error("There was an error!", error);
      });
});
function sortedPlantes(type) {
  if (type) {
    return plantes.value.filter(plante => plante.type === type);
  } else {
    return plantes.value.sort((a, b) => a.type.localeCompare(b.type));
  }
}
const type = ref('');
function allTypes() {
  return [...new Set(plantes.value.map(plante => plante.type))];
}
function getImage(type) {
  if (type === 'feuille') {
    return cannabisLeafImage;
  } else if (type === 'champignon') {
    return mushroomImage;
  }
  return '';
}
function deletePlante(id) {
  if (confirm('Êtes-vous sûr de vouloir supprimer cette plante?')) {
    axios.delete(`http://localhost:8080/api/plant/delete/${id}`)
        .then(response => {
          plantes.value = plantes.value.filter(plante => plante.id !== id);
          alert('Plante supprimée avec succès!');
        })
        .catch(error => {
          console.error("Erreur lors de la suppression de la plante!", error);
        });
  }
}

</script>

<template>
  <h1>Plantes</h1>
  <div v-for="typeIndex in allTypes()" class="d-inline-flex">
    <button @click="type = typeIndex" class="btn btn-primary m-2">{{ typeIndex }}</button>
  </div>
  <div class="row">
    <div v-for="plante in sortedPlantes(type)" :key="plante.name" class="col-md-4 m-4 card-plant shadow">
      <div class="row min-vw-50">
        <img :src="getImage(plante.type)" class="card-img-left img-fluid col-md-6">
        <div class="card-body col-md-6">
          <h5 class="card-title">{{ plante.name }}</h5>
          <p class="card-text">Type: {{ plante.type }}</p>
          <p class="card-text">Variété: {{ plante.variety }}</p>
          <p class="card-text">Surface occupée: {{ plante.spaceUse }} cm²</p>
          <router-link :to="`/plant/edit/`+ plante.id" class="btn btn-primary m-1">Modifier</router-link>
          <button @click="deletePlante(plante.id)" class="btn btn-danger m-1">Supprimer</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.card-image {
  width: 100%;
  height: auto;
  object-fit: cover;
}

.card-content {
  text-align: center;
}
.card-plant {
  padding: 5px;
  background-color: rgba(192, 192, 192, 0.4);
  border-radius: 10px;
}
</style>