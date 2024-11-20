const express = require('express');
const router = express.Router();
const { obtenerYGuardarConsulta } = require('../controllers/colaboradorController');

// Ruta para buscar y guardar datos
router.get('/:codigoModular', async (req, res) => {
    try {
        const codigoModular = req.params.codigoModular;
        const resultados = await obtenerYGuardarConsulta(codigoModular);
        res.json(resultados);
    } catch (error) {
        console.error(error);
        res.status(500).send('Error al procesar la consulta');
    }
});

module.exports = router;
