import { createMemoryHistory, createRouter } from 'vue-router'
import CreatePotager from "@/router/components/Pottage/CreatePotager.vue";
import DeletePotager from "@/router/components/Pottage/DeletePotager.vue";
import HomePage from "@/components/HomePage.vue";
import UpdatePotager from "@/router/components/Pottage/UpdatePotager.vue";

const routes = [
  { path: '/', component: HomePage },
  { path: '/create-potager', component: CreatePotager},
  { path: '/update-potager', component: UpdatePotager},
  { path: '/delete-potager', component: DeletePotager},
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
