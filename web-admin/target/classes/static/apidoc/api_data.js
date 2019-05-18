define({ "api": [
  {
    "type": "GET",
    "url": "/calculateBalanceTargetValue",
    "title": "计算上月余额与目标降低值表",
    "name": "calculateBalanceTargetValue______________",
    "group": "BalanceTargetValue",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定计算上月余额与目标降低值表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定计算上月余额与目标降低值表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /calculateBalanceTargetValue?year= month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"执行计算\",\"data\":[\n{\"id\":289,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":2090.00,\"planMonthTargetValue\":33.00,\"planTotalReduceValue\":166.00,\"actualMonthTargetValue\":-979.00,\"\nactualTotalReduceValue\":1101.00,\"monthIncrementalValue\":-11013.75,\"totalIncrementalValue\":12386.25,\"monthReward\":-154412.78,\"totalReward\":173655.23,\"createDate\":\"2019-05-16T07:59:11.000+0000\",\n\"itemDept\":null,\"itemEmployee\":null,\"reportItemInstance\":null},\n{\"id\":553,\"reportItemId\":2,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":50000.00,\"planMonthTargetValue\":83.33,\"planTotalReduceValue\":177.67,\"actualMonthTargetValue\":-47778.00,\n\"actualTotalReduceValue\":2212.00,\"monthIncrementalValue\":-537502.50,\"totalIncrementalValue\":24885.00,\"monthReward\":-7535785.05,\"totalReward\":348887.70,\"createDate\":\"2019-05-16T07:59:11.000+0000\",\n\"itemDept\":null,\"itemEmployee\":null,\"reportItemInstance\":null},\n{\"id\":554,\"reportItemId\":3,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":1020.00,\"planMonthTargetValue\":98777.00,\"planTotalReduceValue\":106554.00,\"actualMonthTargetValue\":4224.00,\n\"actualTotalReduceValue\":5234.00,\"monthIncrementalValue\":47520.00,\"totalIncrementalValue\":58882.50,\"monthReward\":666230.40,\"totalReward\":825532.65,\"createDate\":\"2019-05-16T07:59:11.000+0000\",\n\"itemDept\":null,\"itemEmployee\":null,\"reportItemInstance\":null},\n{\"id\":555,\"reportItemId\":4,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":5020.00,\"planMonthTargetValue\":6222.00,\"planTotalReduceValue\":6247.00,\"actualMonthTargetValue\":-576.00,\n\"actualTotalReduceValue\":4434.00,\"monthIncrementalValue\":-6480.00,\"totalIncrementalValue\":49882.50,\"monthReward\":-90849.60,\"totalReward\":699352.65,\"createDate\":\"2019-05-16T07:59:11.000+0000\",\n\"itemDept\":null,\"itemEmployee\":null,\"reportItemInstance\":null}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/calculateBalanceTargetValue"
      }
    ]
  },
  {
    "type": "Post",
    "url": "/createMoreBalanceTargetValue",
    "title": "批量插入上月余额与目标降低值表信息",
    "name": "createMoreBalanceTargetValue__________________",
    "group": "BalanceTargetValue",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n{\n \"reportItemId\":2,\n \"year\":2019,\n \"month\":3,\n \"lastMonthBalance\":45,\n \"planMonthTargetValue\":65,\n \"planTotalReduceValue\":85,\n \"actualMonthTargetValue\":98,\n \"actualTotalReduceValue\":98,\n \"monthIncrementalValue\":78,\n \"totalIncrementalValue\":78,\n \"monthReward\":25,\n \"totalReward\":12,\n \"date\":\"2019-05-06\"\n},\n{\n \"reportItemId\":3,\n \"year\":2019,\n \"month\":5,\n \"lastMonthBalance\":845,\n \"planMonthTargetValue\":165,\n \"planTotalReduceValue\":85,\n \"actualMonthTargetValue\":988,\n \"actualTotalReduceValue\":98,\n \"monthIncrementalValue\":78,\n \"totalIncrementalValue\":78,\n \"monthReward\":25,\n \"totalReward\":12,\n \"date\":\"2019-05-06\"\n}\n]\nPOST: /createMoreBalanceTargetValue\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量增加记录成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/createMoreBalanceTargetValue"
      }
    ]
  },
  {
    "type": "Delete",
    "url": "/deleteAllBalanceTargetValue",
    "title": "删除所有上月余额与目标降低值表信息",
    "name": "deleteAllBalanceTargetValue__________________",
    "group": "BalanceTargetValue",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "Delete: /deleteAllBalanceTargetValue\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"清空数据成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllBalanceTargetValue"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryAllBalanceTargetValue",
    "title": "查询所有上月余额与目标降低值",
    "name": "queryAllBalanceTargetValue_______________",
    "group": "BalanceTargetValue",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryAllBalanceTargetValue\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询数据成功\",\"data\":[\n{\"id\":11,\"reportItemId\":2,\"year\":\"2019\",\"month\":\"5\",\"lastMonthBalance\":45.0000,\"planMonthTargetValue\":65.0000,\n\"planTotalReduceValue\":85.0000,\"actualMonthTargetValue\":7500.0000,\"actualTotalReduceValue\":98.0000,\"monthIncrementalValue\":78.0000,\n\"totalIncrementalValue\":99999.0000,\"monthReward\":25.0000,\"totalReward\":12.0000,\"date\":\"2019-05-06 00:00:00.0\"},\n{\"id\":12,\"reportItemId\":3,\"year\":\"2019\",\"month\":\"4\",\"lastMonthBalance\":405.0000,\"planMonthTargetValue\":605.0000,\n\"planTotalReduceValue\":85.0000,\"actualMonthTargetValue\":7500.0000,\"actualTotalReduceValue\":98.0000,\"monthIncrementalValue\":708.0000,\n\"totalIncrementalValue\":999.0000,\"monthReward\":25.0000,\"totalReward\":12.0000,\"date\":\"2019-05-06 00:00:00.0\"}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryAllBalanceTargetValue"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryBalanceTargetValue?year=&month=",
    "title": "根据年月查询上月余额与目标降低值表",
    "name": "queryBalanceTargetValue__________________",
    "group": "BalanceTargetValue",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定上月余额与目标降低值表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定上月余额与目标降低值表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryBalanceTargetValue?year= & month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询数据成功\",\"data\":[{\"id\":11,\"reportItemId\":2,\"year\":\"2019\",\"month\":\"5\",\"lastMonthBalance\":45.0000,\"planMonthTargetValue\":65.0000,\n\"planTotalReduceValue\":85.0000,\"actualMonthTargetValue\":7500.0000,\"actualTotalReduceValue\":98.0000,\"monthIncrementalValue\":78.0000,\n\"totalIncrementalValue\":99999.0000,\"monthReward\":25.0000,\"totalReward\":12.0000,\"date\":\"2019-05-06 00:00:00.0\"}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryBalanceTargetValue?year=&month="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryFoundCost",
    "title": "查询流动资金占用成本管控目标完成情况分析",
    "name": "queryFoundCost_____________________",
    "group": "FoundCost",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定流动资金占用成本管控目标完成情况分析year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定流动资金占用成本管控目标完成情况分析month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryFoundCost?year= month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":{\n\"totalDifference\":[935.00],\n\"foundCosts\":[\n{\"id\":null,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":null,\"planMonthTargetValue\":33.00,\"planTotalReduceValue\":166.00,\n\"actualMonthTargetValue\":1091.00,\"actualTotalReduceValue\":1101.00,\"monthIncrementalValue\":null,\"totalIncrementalValue\":null,\"monthReward\":null,\"totalReward\":null,\"createDate\":null,\n\"itemDept\":[\n{\"id\":null,\"reportItemId\":1,\"isCharge\":1,\"deptCode\":\"C500\",\n\"department\":\n{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}},\n{\"id\":null,\"reportItemId\":1,\"isCharge\":0,\"deptCode\":\"C500\",\n\"department\":\n{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}}],\"itemEmployee\":null,\n\"reportItemInstance\":\n{\"id\":null,\"reportItemId\":null,\"reportCode\":null,\"reportName\":null,\"objectType\":null,\"objectId\":null,\"itemCode\":null,\"itemName\":\"货币资金\",\"orderNum\":null,\"year\":null,\"month\":null,\"beginValue\":null,\"value\":null,\"endValue\":null,\"modifyTime\":null}}]}\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/FoundCostController.java",
    "groupTitle": "FoundCost",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryFoundCost"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryFoundIncrementalValue",
    "title": "查询流动资金占用成本管控增创价值表",
    "name": "queryFoundIncrementalValue__________________",
    "group": "FoundIncrementalValue",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定流动资金占用成本管控增创价值表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定流动资金占用成本管控增创价值表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryFoundIncrementalValue?year= month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":[\n{\"id\":null,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":null,\"planMonthTargetValue\":null,\"planTotalReduceValue\":null,\"actualMonthTargetValue\":1091.00,\n\"actualTotalReduceValue\":1101.00,\"monthIncrementalValue\":12273.75,\"totalIncrementalValue\":12386.25,\"monthReward\":172077.98,\"totalReward\":173655.23,\"createDate\":null,\n\"itemDept\":[\n{\"id\":null,\"reportItemId\":1,\"isCharge\":1,\"deptCode\":\"C500\",\"department\":{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}},\n{\"id\":null,\"reportItemId\":1,\"isCharge\":0,\"deptCode\":\"C500\",\"department\":{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}}],\n\"itemEmployee\":null,\n\"reportItemInstance\":\n{\"id\":null,\"reportItemId\":null,\"reportCode\":null,\"reportName\":null,\"objectType\":null,\"objectId\":null,\"itemCode\":null,\"itemName\":\"货币资金\",\"orderNum\":null,\"year\":null,\"month\":null,\"beginValue\":null,\"value\":null,\"endValue\":null,\"modifyTime\":null}}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/FoundIncrementalValueController.java",
    "groupTitle": "FoundIncrementalValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryFoundIncrementalValue"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/improvementPlans",
    "title": "删除所有提升和改善计划表信息",
    "name": "deleteAllImprovementPlans______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /improvementPlans\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlans"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/improvementPlan",
    "title": "删除指定提升和改善计划表信息",
    "name": "deleteImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定提升和改善计划表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /improvementPlan?id=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlan"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/improvementPlan",
    "title": "插入提升和改善计划表信息",
    "name": "insertImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ok",
            "description": "<p>完成情况</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "plan",
            "description": "<p>改善计划</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /improvementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlan"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/improvementPlans",
    "title": "查询所有提升和改善计划表信息",
    "name": "queryAllImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /improvementPlans\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\n\"data\":[\n         {\n             \"id\":1,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                      \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n             },\n         {\n             \"id\":2,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n           }\n      ]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlans"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/improvementPlan?id=",
    "title": "查询指定提升和改善计划表信息",
    "name": "selectImprovementPlanById_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定提升和改善计划表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /improvementPlanById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定提升和改善计划表成功\",\n\"data\":{\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"\n\"item\":{\n         \"item_code\"=\"短期投资\"\n         \"item_name\"=\"短期投资\"\n         \"calc_expr=\"1101-1102\"\n         \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n         \"state\"=\"1\"\n         \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlan?id="
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/improvementPlan",
    "title": "更新指定提升和改善计划表信息",
    "name": "updateImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>提升和改善计划表id</p>"
          },
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ok",
            "description": "<p>完成情况</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "plan",
            "description": "<p>改善计划</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":1,\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /improvementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlan"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/incentiveRatio",
    "title": "添加一条部门奖励比例",
    "name": "addIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n}\nPOST: /incentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加一条部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatio"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/incentiveRatios",
    "title": "删除所有部门奖励比例",
    "name": "deleteAllIncentiveRatios___________",
    "group": "IncentiveRatio",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /incentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatios"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/incentiveRatio?id=",
    "title": "删除指定部门奖励比例",
    "name": "deleteIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /incentiveRatio?id=211\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatio?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/incentiveRatios",
    "title": "查询所有部门奖励比例",
    "name": "queryAllIncentiveRatios___________",
    "group": "IncentiveRatio",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /incentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询所有部门奖励比例成功\",\n\"data\":[\n     {\n         \"id\":200,\n         \"year\":\"2018\",\n         \"interest_rate\":10.01,\n         \"incentive_ratio\":12.01,\n         \"max_limit\":15.02,\n         \"create_date\":2019-05-09T13:14:48.000+0000\n     },\n     {\n         \"id\":201,\n         \"year\":\"2018\",\n         \"interest_rate\":12.55,\n         \"incentive_ratio\":14,\n         \"max_limit\":18.1,\n         \"create_date\":2019-05-09T13:15:01.000+0000\n     }\n])",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatios"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/incentiveRatio?id=",
    "title": "查询指定部门奖励比例",
    "name": "queryIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /incentiveRatio?id=200\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询指定部门奖励比例成功\",\n\"data\":{\n         \"id\":200,\n         \"year\":\"2018\",\n         \"interest_rate\":10.01,\n         \"incentive_ratio\":12.01,\n         \"max_limit\":15.02,\n         \"create_date\":2019-05-09T13:14:48.000+0000\n     }",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatio?id="
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/incentiveRatio",
    "title": "更改指定部门奖励比例",
    "name": "updateIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"id\":200,\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n}\nPUT: /incentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改指定部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatio"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/incentiveRatios",
    "title": "批量更改部门奖励比例",
    "name": "updateIncentiveRatios___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n     {\n         \"id\":200,\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n     },\n     {\n         \"id\":201,\n         \"year\":\"2019\",\n         \"interest_rate\":45.04,\n         \"incentive_ratio\":45.04,\n         \"max_limit\":45.04\n     }\n]\nPUT: /incentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更改部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incentiveRatios"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/monthReports",
    "title": "删除所有流动资金成本管控情况月度总结情况报告表信息",
    "name": "deleteAllMonthReport__________________________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /monthReports\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\n     \"code\":0,\n     \"message\":\"删除所有流动资金成本管控情况月度总结情况报告表成功\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReports"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/monthReport?id=",
    "title": "删除指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "deleteMonthReport__________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定 流动资金成本管控情况月度总结情况报告表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /monthReport?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\n     \"code\":0,\n     \"message\":\"删除指定流动资金成本管控情况月度总结情况报告表成功\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReport?id="
      }
    ]
  },
  {
    "type": "POST",
    "url": "/monthReport",
    "title": "插入流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReport________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "target",
            "description": "<p>目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "value",
            "description": "<p>末余额</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "difference",
            "description": "<p>偏差值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "measure",
            "description": "<p>本期主要管控措施</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "experience",
            "description": "<p>经验</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deficiency",
            "description": "<p>不足</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "evaluate",
            "description": "<p>考核人评价</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入流动资金成本管控情况月度总结情况报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReport"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/monthReport",
    "title": "更新指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReport__________________________",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>流动资金成本管控情况月度总结情况报告表id</p>"
          },
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "target",
            "description": "<p>目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "value",
            "description": "<p>末余额</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "difference",
            "description": "<p>偏差值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "measure",
            "description": "<p>本期主要管控措施</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "experience",
            "description": "<p>经验</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deficiency",
            "description": "<p>不足</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "evaluate",
            "description": "<p>考核人评价</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPUT /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "group": "MonthReport",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新流动资金成本管控情况月度总结情况报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReport"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/monthReports",
    "title": "查询所有流动资金成本管控情况月度总结情况报告表信息",
    "name": "queryAllImonthReport__________________________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /monthReports\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询所有流动资金成本管控情况月度总结情况报告表成功\",\"data\":\n[\n    {\n     \"id\":1,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00-01\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     },\n    {\n     \"id\":2,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     }\n ]\n }",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReports"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/monthReport?id=",
    "title": "查询指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "selectMonthReportById__________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定流动资金成本管控情况月度总结情况报告表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /monthReport?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定流动资金成本管控情况月度总结情况报告表成功\",\n\"data\":\n{    \"id\":1,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\n     \"ok\":1,\n     \"plan\":\"1\",\n     \"remark\":\"1\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n}\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReport?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionAndReport?year=year&&month=month&&type=type",
    "title": "查询指定项目占比（资产和负债）",
    "name": "selectProportionAndReport_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定项目占比表年</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定项目占比表月</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "type",
            "description": "<p>查询指定项目占比（资产和负债）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionAndReport?year=year&&month=month&&type=type\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionAndReport?year=year&&month=month&&type=type"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionById?id=",
    "title": "查询指定项目占比",
    "name": "selectProportionById_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目占比表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionById?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionByYearAndMonth?year=year&&month=month",
    "title": "查询指定项目占比",
    "name": "selectProportionById_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定项目占比表年</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定项目占比表月</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionByYearAndMonth?year=&&month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionByYearAndMonth?year=year&&month=month"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/reduceTargets",
    "title": "删除所有项目降低目标设置",
    "name": "deleteAllReduceTargets_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /reduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有项目降低目标设置\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/reduceTarget?id=",
    "title": "删除指定项目降低目标设置",
    "name": "deleteReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /reduceTarget?id=230\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"根据id删除一条指定项目降低目标设置成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget?id="
      }
    ]
  },
  {
    "type": "POST",
    "url": "/reduceTarget",
    "title": "添加一条项目降低目标设置",
    "name": "insertReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份</p>"
          },
          {
            "group": "Parameter",
            "type": "Double",
            "optional": false,
            "field": "year_percent",
            "description": "<p>年度百分比，单位%</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "last_year_value",
            "description": "<p>去年实际降低额</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "asset_or_debt",
            "description": "<p>资产或负债，0资产  1负债</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":1,\n\"year\":\"2018\",\n\"year_percent\":0,\n\"year_value\":5525.02,\n\"last_year_value\":0,\n\"asset_or_debt\":1\n}\nPOST: /reduceTarget\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加一条项目降低目标设置\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/reduceTargets",
    "title": "查询所有项目降低目标设置",
    "name": "queryAllReduceTargets_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /reduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询所有项目降低目标设置成功\",\"data\":[\n\"data\":{\"id\":208,\"\n         report_item_id\":0,\n         \"year\":\"\",\n         \"year_percent\":0,\n         \"year_value\":635184.75,\n         \"last_year_value\":,\n         \"jan\":52932.062,\n         \"feb\":52932.062,\n         \"mar\":52932.062,\n         \"apr\":52932.062,\n         \"may\":52932.062,\n         \"jun\":52932.062,\n         \"jul\":52932.062,\n         \"aug\":52932.062,\n         \"sept\":52932.062,\n         \"oct\":52932.062,\n         \"nov\":52932.062,\n         \"dec\":52932.062,\n         \"asset_or_debt\":true\n         \"create_date\":2019-05-15T08:52:45.000+0000\n         \"item\":{\n             \"item_code\"=\"货币资金\"\n             \"item_name\"=\"货币资金\"\n             \"calc_expr=\"1001+1002+1009\"\n             \"calc_explain\"=\"现金+银行存款+其他货币资金\"\n             \"state\"=\"1\"\n             \"modify_time\"= 2019-04-28T01:54:33.000+0000\n         }\n       },\n\"data\":{\"id\":209,\"\n         report_item_id\":0,\n         \"year\":\"\",\n         \"year_percent\":0,\n         \"year_value\":1000.0000,\n         \"last_year_value\":,\n         \"jan\":83.3333,\n         \"feb\":83.3333,\n         \"mar\":83.3333,\n         \"apr\":83.3333,\n         \"may\":83.3333,\n         \"jun\":83.3333,\n         \"jul\":83.3333,\n         \"aug\":83.3333,\n         \"sept\":83.3333,\n         \"oct\":83.3333,\n         \"nov\":83.3333,\n         \"dec\":83.3337,\n         \"asset_or_debt\":true\n         \"create_date\":2019-05-15T08:53:10.000+0000\n         \"item\":{\n             \"item_code\"=\"短期投资\"\n             \"item_name\"=\"短期投资\"\n             \"calc_expr=\"1101-1102\"\n             \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n             \"state\"=\"1\"\n             \"modify_time\"= 2019-04-28T01:59:55.000+0000\n         }\n       }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/reduceTarget?id=",
    "title": "查询指定项目降低目标设置",
    "name": "queryReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /reduceTarget?id=208\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询指定项目降低目标设置\",\n\"data\":{\"id\":208,\"\n         report_item_id\":0,\n         \"year\":\"\",\n         \"year_percent\":0,\n         \"year_value\":635184.75,\n         \"last_year_value\":,\n         \"jan\":52932.062,\n         \"feb\":52932.062,\n         \"mar\":52932.062,\n         \"apr\":52932.062,\n         \"may\":52932.062,\n         \"jun\":52932.062,\n         \"jul\":52932.062,\n         \"aug\":52932.062,\n         \"sept\":52932.062,\n         \"oct\":52932.062,\n         \"nov\":52932.062,\n         \"dec\":52932.062,\n         \"asset_or_debt\":true\n         \"create_date\":2019-05-15T08:52:45.000+0000\n         \"item\":{\n             \"item_code\"=\"货币资金\"\n             \"item_name\"=\"货币资金\"\n             \"calc_expr=\"1001+1002+1009\"\n             \"calc_explain\"=\"现金+银行存款+其他货币资金\"\n             \"state\"=\"1\"\n             \"modify_time\"= 2019-04-28T01:54:33.000+0000\n         }\n       }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget?id="
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTarget_month",
    "title": "更改指定项目月降低目标设置",
    "name": "updateReduceTarget_month______________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "jan",
            "description": "<p>一月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "feb",
            "description": "<p>二月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "mar",
            "description": "<p>三月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "apr",
            "description": "<p>四月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "may",
            "description": "<p>五月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "jun",
            "description": "<p>六月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "jul",
            "description": "<p>七月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "aug",
            "description": "<p>八月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "sept",
            "description": "<p>九月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "oct",
            "description": "<p>十月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "nov",
            "description": "<p>十一月份</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "dec",
            "description": "<p>十二月份</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":208,\n\"jan\":83.3334\n\"feb\":83.3332\n\"mar\":83.3333\n\"apr\":83.3333\n\"may\":83.3333\n\"jun\":83.3333\n\"jul\":83.3333\n\"aug\":83.3333\n\"sept\":83.3333\n\"oct\":83.3333\n\"nov\":83.3333\n\"dec\":83.3337\n}\nPUT: /reduceTarget_month\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改指定项目年降低目标设置\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget_month"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTarget_year",
    "title": "更改指定项目年降低目标设置",
    "name": "updateReduceTarget_year______________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":229,\n\"year_value\":635184.7500\n}\nPUT: /reduceTarget_year\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改指定项目年降低目标设置\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget_year"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTargets_year",
    "title": "批量更改项目年降低目标成功",
    "name": "updateReduceTargets_year______________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n{\"id\":226,\"year_value\":5000},\n{\"id\":227,\"year_value\":5000},\n{\"id\":228,\"year_value\":5000}\n]\nPUT: /reduceTargets_year\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更改项目年降低目标成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_year"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllReportItemInstance",
    "title": "查询所有reportItemInstance",
    "name": "getAllReportItemInstance___reportItemInstance__",
    "group": "ReportItemInstance",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllReportItemInstance\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找reportItemInstance表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReportItemInstanceMapperController.java",
    "groupTitle": "ReportItemInstance",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllReportItemInstance"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectReportItemInstanceByYearAndMonth",
    "title": "查询指定年月的reportItemInstance",
    "name": "selectReportItemInstanceByYearAndMonth___reportItemInstance__",
    "group": "ReportItemInstance",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllReportItemInstance\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找reportItemInstance表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReportItemInstanceMapperController.java",
    "groupTitle": "ReportItemInstance",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectReportItemInstanceByYearAndMonth"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getResponsibilityIndicator",
    "title": "查询流动资金占用成本管控责任关键指标",
    "name": "queryResponsibilityIndicator___________________",
    "group": "ResponsibilityIndicator",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定动资金占用成本管控责任关键指标表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定动资金占用成本管控责任关键指标表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getResponsibilityIndicator？year= month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":[\n{\"id\":null,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":20.00,\"planMonthTargetValue\":33.00,\"planTotalReduceValue\":null,\n\"actualMonthTargetValue\":null,\"actualTotalReduceValue\":null,\"monthIncrementalValue\":null,\"totalIncrementalValue\":null,\"monthReward\":null,\n\"totalReward\":null,\"createDate\":null,\n\"itemDept\":[\n{\"id\":null,\"reportItemId\":1,\"isCharge\":1,\"deptCode\":\"C500\",\"\ndepartment\":\n{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}},\n{\"id\":null,\"reportItemId\":1,\"isCharge\":0,\"deptCode\":\"C500\",\n\"department\":\n{\"id\":null,\"deptCode\":\"C500\",\"deptName\":\"战略客户部公共\",\"parentDeptCode\":null,\"level\":null,\"state\":null,\"modifyTime\":null}}\n],\n\"itemEmployee\":[\n{\"id\":1,\"reportItemId\":1,\"isCharge\":0,\"employeeId\":449,\n\"employee\":\n{\"id\":449,\"employeeCode\":null,\"simpleCode\":null,\"employeeName\":\"-*-\",\"employeeType\":null,\"deptCode\":null,\"state\":null,\"modifyTime\":null}},\n{\"id\":5,\"reportItemId\":1,\"isCharge\":1,\"employeeId\":453,\n\"employee\":\n{\"id\":453,\"employeeCode\":null,\"simpleCode\":null,\"employeeName\":\"郭*芸\",\"employeeType\":null,\"deptCode\":null,\"state\":null,\"modifyTime\":null}}\n],\n\"reportItemInstance\":\n{\"id\":null,\"reportItemId\":null,\"reportCode\":null,\"reportName\":null,\"objectType\":null,\"objectId\":null,\"itemCode\":null,\"itemName\":\"货币资金\",\"orderNum\":null,\"year\":null,\"month\":null,\"beginValue\":null,\"value\":null,\"endValue\":null,\"modifyTime\":null}}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ResponsibilityIndicatorController.java",
    "groupTitle": "ResponsibilityIndicator",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getResponsibilityIndicator"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryTargetMatching",
    "title": "查询流动资产与流动负债目标匹配表",
    "name": "queryTargetMatching_________________",
    "group": "TargetMatching",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定流动资产与流动负债目标匹配表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定流动资产与流动负债目标匹配表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryTargetMatching?year= month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":[\n{\"id\":null,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"3\",\"lastMonthBalance\":20.00,\"planMonthTargetValue\":33.00,\"planTotalReduceValue\":null,\"actualMonthTargetValue\":null,\n\"actualTotalReduceValue\":null,\"monthIncrementalValue\":null,\"totalIncrementalValue\":null,\"monthReward\":null,\"totalReward\":null,\"createDate\":null,\"itemDept\":null,\n\"itemEmployee\":[\n{\"id\":1,\"reportItemId\":1,\"isCharge\":0,\"employeeId\":449,\"employee\":\n{\"id\":449,\"employeeCode\":null,\"simpleCode\":null,\"employeeName\":\"-*-\",\"employeeType\":null,\"deptCode\":null,\"state\":null,\"modifyTime\":null}},\n{\"id\":5,\"reportItemId\":1,\"isCharge\":1,\"employeeId\":453,\"employee\":\n{\"id\":453,\"employeeCode\":null,\"simpleCode\":null,\"employeeName\":\"郭*芸\",\"employeeType\":null,\"deptCode\":null,\"state\":null,\"modifyTime\":null}}],\n\"reportItemInstance\":\n{\"id\":null,\"reportItemId\":null,\"reportCode\":null,\"reportName\":null,\"objectType\":null,\"objectId\":null,\"itemCode\":null,\"itemName\":\"货币资金\",\"orderNum\":null,\"year\":null,\"month\":null,\"beginValue\":null,\"value\":null,\"endValue\":null,\"modifyTime\":null}}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/TargetMatchingController.java",
    "groupTitle": "TargetMatching",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryTargetMatching"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/orders",
    "title": "查询订单信息",
    "name": "queryAll_______",
    "group": "api",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /orders\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":[{\"id\":1,\"name\":\"order1\",\"goodsNum\":1},{\"id\":2,\"name\":\"order2\",\"goodsNum\":2}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/OrderController.java",
    "groupTitle": "api",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/orders"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/deleteAllProportion",
    "title": "删除所有项目占比表记录",
    "name": "deleteAllProportion____________",
    "group": "deleteAllProportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteAllProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有项目占比表记录\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "deleteAllProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllProportion"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/deleteProportionById",
    "title": "删除指定项目占比表记录",
    "name": "deleteImprovementPlanById____________",
    "group": "deleteProportionById",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>删除指定项目占比表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteProportionById?id=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定项目占比表记录成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "deleteProportionById",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteProportionById"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllProportion",
    "title": "查找所有项目占比表记录",
    "name": "getAllProportion____________",
    "group": "getAllProportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找所有项目占比表记录成功\",\n\"data\":[\n{\n\"id\":143,\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0.6196991,\n\"accumulate_proportion\":0.6196991,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"},\n{\n\"id\":146,\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0,\n\"accumulate_proportion\":0.75356704,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"\n}\n]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "getAllProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllProportion"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/insertProportion",
    "title": "插入项目占比表",
    "name": "insertProportion________",
    "group": "insertProportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "proportion",
            "description": "<p>比例</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "accumulate_proportion",
            "description": "<p>累计比例</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "asset_or_debt",
            "description": "<p>资产或负债</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0,\n\"accumulate_proportion\":0.75356704,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"\n}\nPOST: /insertImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入项目占比表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "insertProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/insertProportion"
      }
    ]
  }
] });