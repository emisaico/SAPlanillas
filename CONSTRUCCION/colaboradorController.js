const db = require('../config/db');

// Buscar colaborador por código modular
const buscarPorCodigoModular = async (codigoModular) => {
    const query = `
        SELECT 
            c.nombres,
            c.apellido_paterno,
            c.apellido_materno,
            p.periodo,
            pc.total_haber,
            pc.total_descuento
        FROM 
            colaborador c
        INNER JOIN 
            planilla_colaborador pc ON c.id_colaborador = pc.id_colaborador
        INNER JOIN 
            planilla p ON pc.id_planilla = p.id_planilla
        WHERE 
            c.codigo_modular = ?;
    `;
    const [results] = await db.execute(query, [codigoModular]);
    return results;
};

// Guardar un log de la consulta automáticamente
const guardarLogConsulta = async (codigoModular) => {
    const query = `
        INSERT INTO logs_consultas (codigo_modular, fecha_consulta) 
        VALUES (?, NOW());
    `;
    await db.execute(query, [codigoModular]);
};

// Función que combina búsqueda y guardado automático
const obtenerYGuardarConsulta = async (codigoModular) => {
    const resultados = await buscarPorCodigoModular(codigoModular);
    await guardarLogConsulta(codigoModular); // Guardar automáticamente
    return resultados;
};

module.exports = { obtenerYGuardarConsulta };
