const express = require('express');
const app = express();
const colaboradorRoutes = require('./routes/colaborador');

// Middleware para manejar JSON
app.use(express.json());

// Rutas
app.use('/api/colaboradores', colaboradorRoutes);

// Servidor
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
