<template>
  <div class="container">
    <h1>Plantes</h1>
    <div class="row">
      <div v-for="plante in sortedPlantes" :key="plante.name" class="col-md-3 m-4">
        <div class="row min-vw-50">
          <img :src="getImage(plante.type)" class="card-img-left img-fluid col-md-6">
          <div class="card-body col-md-6">
            <h5 class="card-title">{{ plante.name }}</h5>
            <p class="card-text">Type: {{ plante.type }}</p>
            <p class="card-text">Variété: {{ plante.variety }}</p>
            <p class="card-text">Surface occupée: {{ plante.spaceUse }} cm²</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import cannabisLeafImage from '@/assets/cannabis.jpg';
import mushroomImage from '@/assets/mushroom.jpg';

export default {
  data() {
    return {
      plantes: []
    };
  },
  computed: {
    sortedPlantes() {
      return this.plantes.sort((a, b) => a.type.localeCompare(b.type));
    }
  },
  methods: {
    getImage(type) {
      if (type === 'feuille') {
        return cannabisLeafImage;
      } else if (type === 'champignon') {
        return mushroomImage;
      }
      return '';
    }
  },
  mounted() {
    axios.get('http://localhost:8080/api/plant/getAll')
        .then(response => {
          this.plantes = response.data;
        })
        .catch(error => {
          console.error("There was an error!", error);
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
</style>
