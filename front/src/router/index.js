import { createMemoryHistory, createRouter } from 'vue-router'
import CreatePotager from "@/router/components/Pottage/CreatePotager.vue";
import DeletePotager from "@/router/components/Pottage/DeletePotager.vue";
import CreatePotager from "@/router/components/CreatePotager.vue";
import CreatePlant from "@/router/components/Plant/CreatePlant.vue";
import EditPlant from "@/router/components/Plant/EditPlant.vue";
import DeletePlant from "@/router/components/Plant/DeletePlant.vue";
import HomePage from "@/components/HomePage.vue";
import UpdatePotager from "@/router/components/Pottage/UpdatePotager.vue";

const routes = [
  { path: '/', component: HomePage },
  { path: '/create-potager', component: CreatePotager},
  { path: '/update-potager', component: UpdatePotager},
  { path: '/delete-potager', component: DeletePotager},
  { path: '/plant/create', name: CreatePlant, component: CreatePlant},
  { path: '/plant/edit/:id', name: EditPlant, component: EditPlant, props: true},
  { path: '/plant/delete/:id', name: DeletePlant, component: DeletePlant, props: true}
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
