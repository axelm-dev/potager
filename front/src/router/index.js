import { createMemoryHistory, createRouter } from 'vue-router'
import CreatePotager from "@/router/components/CreatePotager.vue";
import HomePage from "@/components/HomePage.vue";

const routes = [
  { path: '/', component: HomePage },
  { path: '/create-potager', component: CreatePotager}
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
