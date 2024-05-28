<template>
  <h1>Plantes</h1>
  <div v-for="typeIndex in allTypes()" class="d-inline-flex">
    <button @click="type = typeIndex" class="btn btn-primary m-2">{{ typeIndex }}</button>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row">
        <div v-for="plante in sortedPlantes(type)" :key="plante.name" class="col-md-4 mb-3">
          <div class="card h-100">
            <div class="row no-gutters">
              <div class="col-md-6">
                <img :src="getImage(plante.type)" class="card-img img-fluid">
              </div>
              <div class="col-md-6">
                <div class="card-body">
                  <h5 class="card-title">{{ plante.name }}</h5>
                  <p class="card-text">Type: {{ plante.type }}</p>
                  <p class="card-text">Variété: {{ plante.variety }}</p>
                  <p class="card-text">Surface occupée: {{ plante.spaceUse }} cm²</p>
                  <router-link :to="`/plant/edit/` + plante.id" class="btn btn-primary m-1">Modifier</router-link>
                  <router-link :to="`/plant/show/` +  plante.id" class="btn btn-info m-1">Afficher</router-link>
                  <button @click="deletePlante(plante.id)" class="btn btn-danger m-1">Supprimer</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3">
      <CreatePlant/>
    </div>
  </div>
</template>


<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";
import cannabisLeafImage from "@/assets/cannabis.png";
import mushroomImage from "@/assets/mushroom.png";
import EditPlant from "@/router/components/Plant/EditPlant.vue";
import CreatePlant from "@/router/components/Plant/CreatePlant.vue";

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
  if (type && type !== 'Tout') {
    return plantes.value.filter(plante => plante.type === type);
  } else {
    return plantes.value.sort((a, b) => a.type.localeCompare(b.type));
  }
}
const type = ref('');
function allTypes() {
  // rajouter un bouton tout pour afficher toutes les plantes avec le texte "Tout"
  return ['Tout', ...new Set(plantes.value.map(plante => plante.type))];
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