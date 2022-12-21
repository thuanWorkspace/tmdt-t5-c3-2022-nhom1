import ApexCharts from 'apexcharts';
import React, { useEffect } from 'react';

import Chart from 'react-apexcharts';

function DonutChart({title,Product,value}) {
    
  return (
    <Chart
        width={600}
        height={300}
        series={value}
        type="donut"
        
        options={{
            labels:Product,
            title:{
                text:title,
            },
            plotOptions:{
                pie:{
                    donut:{
                        labels:{
                            show:true,
                            total:{
                                show:true,
                            }
                        }
                    }
                }
            }

        }}>

        </Chart>
  )
}

export default DonutChart;