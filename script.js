// DOM Elements
document.addEventListener('DOMContentLoaded', () => {
    // Navigation buttons
    const sectionButtons = document.querySelectorAll('aside button[data-section]');
    const sections = document.querySelectorAll('main section');
    const logoutBtn = document.getElementById('logout-btn');
    
    // File import elements
    const importBtn = document.getElementById('import-btn');
    const conceptosFile = document.querySelector('input[accept=".txt"]');
    const noAbonosFile = document.querySelector('input[accept=".xlsx,.xls"]');
    const tableContainer = document.getElementById('table-container');
    
    // Individual calculator elements
    const codigoModularInput = document.getElementById('codigo-modular');
    const consultarBtn = document.getElementById('consultar-btn');
    const resultadoConsulta = document.getElementById('resultado-consulta');
    
    // Report elements
    const tipoReporte = document.getElementById('tipo-reporte');
    const periodoReporte = document.getElementById('periodo-reporte');
    const generarReporteBtn = document.getElementById('generar-reporte-btn');
    const resultadoReporte = document.getElementById('resultado-reporte');

    // Navigation functionality
    sectionButtons.forEach(button => {
        button.addEventListener('click', () => {
            const sectionId = button.getAttribute('data-section');
            sections.forEach(section => {
                section.classList.add('hidden');
                if (section.id === sectionId) {
                    section.classList.remove('hidden');
                }
            });
            
            // Update active button state
            sectionButtons.forEach(btn => {
                btn.classList.remove('bg-blue-500');
            });
            button.classList.add('bg-blue-500');
        });
    });

    // Show first section by default
    if (sections.length > 0) {
        sections[0].classList.remove('hidden');
        sectionButtons[0].classList.add('bg-blue-500');
    }

    // File Import Handler
    importBtn.addEventListener('click', () => {
        if (!conceptosFile.files.length && !noAbonosFile.files.length) {
            alert('Por favor seleccione al menos un archivo para importar.');
            return;
        }

        // Simulate file processing
        const filesInfo = [];
        if (conceptosFile.files.length) {
            filesInfo.push({
                nombre: conceptosFile.files[0].name,
                tipo: 'Conceptos Mensuales',
                estado: 'Procesado'
            });
        }
        if (noAbonosFile.files.length) {
            filesInfo.push({
                nombre: noAbonosFile.files[0].name,
                tipo: 'No Abonos',
                estado: 'Procesado'
            });
        }

        // Create and display results table
        const table = createResultsTable(filesInfo);
        tableContainer.innerHTML = '';
        tableContainer.appendChild(table);
        tableContainer.classList.remove('hidden');
    });

    // Individual Calculator Handler
    consultarBtn.addEventListener('click', () => {
        const codigoModular = codigoModularInput.value.trim();
        if (!codigoModular) {
            alert('Por favor ingrese un código modular.');
            return;
        }

        // Simulate API call and display results
        const mockData = {
            nombreEmpleado: 'Juan Ross',
            remuneracionMensual: '3500.00',
            quintaCategoria: '350.00',
            periodo: '2024-03'
        };

        displayConsultaResult(mockData);
    });

    // Report Generation Handler
    generarReporteBtn.addEventListener('click', () => {
        const tipo = tipoReporte.value;
        const periodo = periodoReporte.value;

        if (!periodo) {
            alert('Por favor seleccione un periodo.');
            return;
        }

        // Simulate report generation
        const reportData = generateMockReport(tipo, periodo);
        displayReportResult(reportData);
    });

    // Logout Handler
    logoutBtn.addEventListener('click', () => {
        if (confirm('¿Está seguro que desea cerrar sesión?')) {
            window.location.href = 'login.html'; // Redirect to login page
        }
    });

    // Helper Functions
    function createResultsTable(data) {
        const table = document.createElement('table');
        table.className = 'min-w-full mt-4 bg-white border border-gray-300';
        
        const thead = document.createElement('thead');
        thead.innerHTML = `
            <tr class="bg-gray-100">
                <th class="px-6 py-3 border-b text-left">Archivo</th>
                <th class="px-6 py-3 border-b text-left">Tipo</th>
                <th class="px-6 py-3 border-b text-left">Estado</th>
            </tr>
        `;
        
        const tbody = document.createElement('tbody');
        data.forEach(item => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td class="px-6 py-4 border-b">${item.nombre}</td>
                <td class="px-6 py-4 border-b">${item.tipo}</td>
                <td class="px-6 py-4 border-b">
                    <span class="px-2 py-1 bg-green-100 text-green-800 rounded-full">
                        ${item.estado}
                    </span>
                </td>
            `;
            tbody.appendChild(row);
        });

        table.appendChild(thead);
        table.appendChild(tbody);
        return table;
    }

    function displayConsultaResult(data) {
        resultadoConsulta.innerHTML = `
            <div class="bg-gray-50 p-4 rounded-lg">
                <h4 class="text-lg font-medium mb-3">Resultado de la consulta</h4>
                <div class="grid grid-cols-2 gap-4">
                    <div>
                        <p class="text-sm text-gray-600">Nombre del Empleado:</p>
                        <p class="font-medium">${data.nombreEmpleado}</p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Remuneración Mensual:</p>
                        <p class="font-medium">S/ ${data.remuneracionMensual}</p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Quinta Categoría:</p>
                        <p class="font-medium">S/ ${data.quintaCategoria}</p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Periodo:</p>
                        <p class="font-medium">${data.periodo}</p>
                    </div>
                </div>
            </div>
        `;
        resultadoConsulta.classList.remove('hidden');
    }

    function generateMockReport(tipo, periodo) {
        // Simulate different report types
        const reportTypes = {
            'carga-masiva': {
                title: 'Reporte de Carga Masiva',
                data: [
                    { empleado: 'Juana Pérez Martinez', estado: 'Procesado', fecha: '2024-03', OPC1: '<a href="archivos/Vistas5ta.pdf" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-green-100 hover:bg-green-200 text-lg"> Descargar</a>',
                        OPC2: '<a href="#" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-red-100 hover:bg-red-200 text-lg eliminar-btn">Eliminar</a>'
                    },
                
                    { empleado: 'María García Llantas', estado: 'Procesando', fecha: '2024-03', OPC1: '<a href="archivos/Vistas5ta.pdf" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-green-100 hover:bg-green-200 text-lg"> Descargar</a>',
                        OPC2: '<a href="#" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-red-100 hover:bg-red-200 text-lg eliminar-btn">Eliminar</a>' },

                    {empleado: 'Luca Maicol Sebastian', estado: 'Pendiente', fecha: '2024-03', OPC1: '<a href="archivos/Vistas5ta.pdf" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-green-100 hover:bg-green-200 text-lg"> Descargar</a>',
                        OPC2: '<a href="#" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-red-100 hover:bg-red-200 text-lg eliminar-btn">Eliminar</a>'
                    },

                    {empleado: 'Cristiano Ronaldo de la Cruz', estado: 'Pendiente', fecha: '2024-03', OPC1: '<a href="archivos/Vistas5ta.pdf" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-green-100 hover:bg-green-200 text-lg"> Descargar</a>',
                        OPC2: '<a href="#" class="text-blue-500 font-medium px-4 py-2 rounded-md bg-red-100 hover:bg-red-200 text-lg eliminar-btn">Eliminar</a>'
                    }
                ]
                
            },
            'calculo-5ta': {
                title: 'Reporte de Cálculo de 5ta Categoría',
                data: [
                    { empleado: 'Juan Pérez', monto: '350.00', fecha: '2024-03-15', acciones: '<a href=""> Descargar - Eliminar' },
                    { empleado: 'María García', monto: '420.00', fecha: '2024-03-15' }
                ]
            },
            'cargas-realizadas': {
                title: 'Reporte de Cargas Realizadas',
                data: [
                    { archivo: 'conceptos_marzo.txt', fecha: '2024-03-15', estado: 'Éxito' },
                    { archivo: 'no_abonos_marzo.xlsx', fecha: '2024-03-15', estado: 'Éxito' }
                ]
            }
        };

        return reportTypes[tipo] || reportTypes['carga-masiva'];

    }

    function displayReportResult(reportData) {
        let tableHTML = `
            <div class="bg-gray-50 p-4 rounded-lg">
                <h4 class="text-lg font-medium mb-3">${reportData.title}</h4>
                <table class="min-w-full bg-white border border-gray-300">
                    <thead class="bg-gray-100">
                        <tr>
        `;

        // Generate headers based on the first data item
        const headers = Object.keys(reportData.data[0]);
        headers.forEach(header => {
            tableHTML += `<th class="px-6 py-3 border-b text-left">${header.charAt(0).toUpperCase() + header.slice(1)}</th>`;
        });

        tableHTML += `
                        </tr>
                    </thead>
                    <tbody>
        `;

        // Generate rows
        reportData.data.forEach(item => {
            tableHTML += '<tr>';
            headers.forEach(header => {
                tableHTML += `<td class="px-6 py-4 border-b">${item[header]}</td>`;
            });
            tableHTML += '</tr>';
        });

        tableHTML += `
                    </tbody>
                </table>
            </div>
        `;

        resultadoReporte.innerHTML = tableHTML;
        resultadoReporte.classList.remove('hidden');    
    }

    
        // Manejo de eliminación con delegación de eventos
        tableContainer.addEventListener('click', (event) => {
            // Verificar si el elemento clickeado es un botón de eliminar
            if (event.target && event.target.classList.contains('eliminar-btn')) {
                event.preventDefault(); // Prevenir el comportamiento predeterminado del enlace
    
                // Mostrar cuadro de confirmación
                const confirmar = confirm('¿Está seguro de que desea eliminar este elemento?');
                
                if (confirmar) {
                    // Lógica para eliminar el elemento, por ejemplo, eliminar la fila de la tabla
                    alert('Elemento eliminado'); // Aquí podrías realizar cualquier otra acción, como eliminar la fila de la tabla
                    const row = event.target.closest('tr'); // Buscar la fila más cercana al botón
                    if (row) {
                        row.remove(); // Elimina la fila de la tabla
                    }
                } else {
                    alert('Eliminación cancelada');
                }
            }
        });
    
    

     

});