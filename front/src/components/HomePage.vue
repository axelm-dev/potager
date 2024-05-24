<template>
  <div class="container">
        <PlantPage/>
  </div>
</template>

<script>
import PlantPage from "@/components/PlantPage.vue";

export default {
  components: {PlantPage},
  data() {
  },
  computed: {
  },
  methods: {
  },
  mounted() {

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
