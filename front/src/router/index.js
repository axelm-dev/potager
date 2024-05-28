import { createMemoryHistory, createRouter } from 'vue-router'
import EditPlant from "@/router/components/Plant/EditPlant.vue";
import DeletePlant from "@/router/components/Plant/DeletePlant.vue";
import HomePage from "@/components/HomePage.vue";
import PottagePage from "@/components/PottagePage.vue";
import Actions from "@/router/components/Actions/Actions.vue";
import ShowPlant from "@/router/components/Plant/ShowPlant.vue";

const routes = [
  { path: '/', component: HomePage },
  { path: '/pottage/page', component: PottagePage},
  { path: '/plant/edit/:id', name: EditPlant, component: EditPlant, props: true},
  { path: '/plant/delete/:id', name: DeletePlant, component: DeletePlant, props: true},
  { path: '/plant/show/:id', name: ShowPlant, component: ShowPlant, props: true},
  { path: '/actions', component: Actions},
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
