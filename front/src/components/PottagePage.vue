<template>
  <div class="row">
    <div class="col-md-4">
      <CreatePotager
          @pottageCreated="handlePottageCreated"
          :updatedPottage="updatedPottage"
          :deletedPottageId="deletedPottageId"
      />
    </div>
    <div class="col-md-4">
      <UpdatePotager
          :createdPottage="createdPottage"
          @pottageUpdated="handlePottageUpdated"
          :deletedPottageId="deletedPottageId"
      />
    </div>
    <div class="col-md-4">
      <DeletePotager
          :createdPottage="createdPottage"
          @pottageDeleted="handlePottageDeleted"
          :updatedPottage="updatedPottage"
      />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import CreatePotager from "@/router/components/Pottage/CreatePotager.vue";
import UpdatePotager from "@/router/components/Pottage/UpdatePotager.vue";
import DeletePotager from "@/router/components/Pottage/DeletePotager.vue";

const createdPottage = ref(null);
const updatedPottage = ref(null);
const deletedPottageId = ref(null);

const handlePottageCreated = (pottage) => {
  createdPottage.value = pottage;
  console.log('Potager créé:', createdPottage.value);
};

const handlePottageUpdated = (pottage) => {
  updatedPottage.value = pottage;
  console.log('Potager mis à jour:', updatedPottage.value);
};

const handlePottageDeleted = (pottageId) => {
  deletedPottageId.value = pottageId;
  console.log('Potager supprimé:', deletedPottageId.value);
};
</script>

<style scoped>
</style>
