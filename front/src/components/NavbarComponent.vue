<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <RouterLink to="/" class="navbar-brand">Mon Application</RouterLink>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <RouterLink to="/create-potager" class="nav-link">Créer un potager</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink to="/delete-potager" class="nav-link">Supprimer un potager</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink to="/update-potager" class="nav-link">Mettre à jour un potager</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink to="/plant/create" class="nav-link">Créer une plante</RouterLink>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavbarComponent'
}
</script>

<style scoped>
.navbar {
  margin-bottom: 1rem;
}
</style>