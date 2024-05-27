import { createMemoryHistory, createRouter } from 'vue-router'
import EditPlant from "@/router/components/Plant/EditPlant.vue";
import DeletePlant from "@/router/components/Plant/DeletePlant.vue";
import HomePage from "@/components/HomePage.vue";
import PottagePage from "@/components/PottagePage.vue";

const routes = [
  { path: '/', component: HomePage },
  { path: '/pottage/page', component: PottagePage},
  { path: '/plant/edit/:id', name: EditPlant, component: EditPlant, props: true},
  { path: '/plant/delete/:id', name: DeletePlant, component: DeletePlant, props: true}
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
