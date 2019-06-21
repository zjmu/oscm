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
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定上月余额与目标降低值表reportId值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /calculateBalanceTargetValue?year= &month= &reportId=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8",
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
    "type": "Delete",
    "url": "/deleteAllBalanceTargetValue",
    "title": "删除所有上月余额与目标降低值表信息",
    "name": "deleteAll__________________",
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
    "type": "Delete",
    "url": "/deleteBalanceTargetValue",
    "title": "按年月删除上月余额与目标降低值表信息",
    "name": "deleteByDate___________________",
    "group": "BalanceTargetValue",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "Delete: /deleteBalanceTargetValue\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"清除数据成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteBalanceTargetValue"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryDepartment",
    "title": "获取所有的部门",
    "name": "getAllDepartment________",
    "group": "BalanceTargetValue",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryDepartment\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"获取部门成功，请查询\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryDepartment"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryAllBalanceTargetValue",
    "title": "查询所有上月余额与目标降低值",
    "name": "queryAll_______________",
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
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询数据成功\",\"data\":[\n {\"id\":122,\n \"itemId\":1,\n \"year\":\"2018\",\n \"month\":\"03\",\n \"lastMonthBalance\":2090.00,\n \"planMonthTargetValue\":33.00,\n \"planTotalReduceValue\":166.00,\n \"actualMonthTargetValue\":-979.00,\n \"actualTotalReduceValue\":1101.00,\n \"monthIncrementalValue\":-11013.75,\n \"totalIncrementalValue\":12386.25,\n \"monthReward\":-154412.78,\n \"totalReward\":173655.23,\n \"createDate\":\"2019-05-12T08:01:22.000+0000\",\n \"assetOrDebt\":null,\n \"itemDept\":null,\n \"itemEmployee\":null,\n \"reportItemInstance\":null}\n ]}",
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
    "url": "/queryBalanceTargetValue",
    "title": "根据年月查询上月余额与目标降低值表",
    "name": "queryByDate__________________",
    "group": "BalanceTargetValue",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定上月余额与目标降低值表year</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定上月余额与目标降低值表month</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定上月余额与目标降低值表reportId</p>"
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
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询数据成功\",\"data\":[\n {\"id\":122,\n \"itemId\":1,\n \"year\":\"2018\",\n \"month\":\"03\",\n \"lastMonthBalance\":2090.00,\n \"planMonthTargetValue\":33.00,\n \"planTotalReduceValue\":166.00,\n \"actualMonthTargetValue\":-979.00,\n \"actualTotalReduceValue\":1101.00,\n \"monthIncrementalValue\":-11013.75,\n \"totalIncrementalValue\":12386.25,\n \"monthReward\":-154412.78,\n \"totalReward\":173655.23,\n \"createDate\":\"2019-05-12T08:01:22.000+0000\",\n \"assetOrDebt\":null,\n \"itemDept\":null,\n \"itemEmployee\":null,\n \"reportItemInstance\":null}\n ]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/BalanceTargetValueController.java",
    "groupTitle": "BalanceTargetValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryBalanceTargetValue"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryCompletionByDept",
    "title": "根据部门查询流动资金占用成本管控目标完成情况分析",
    "name": "queryCompletionByDept_________________________",
    "group": "Completion",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资金占用成本管控目标完成情况分析reportId值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deptCode",
            "description": "<p>指定流动资金占用成本管控目标完成情况分析deptCode值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryCompletionByDept?year= &month= &reportId= &deptCode=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"根据部门查询流动资金占用成本管控目标完成情况成功\",\n  \"data\": [\n    {\n      \"planMonthTargetValue\": 47638.88,\n      \"planTotalReduceValue\": 142916.63,\n      \"actualMonthTargetValue\": 233,\n      \"actualTotalReduceValue\": 6161,\n      \"totalDifference\": -136755.63,\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      },\n      \"itemDept\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ]\n    }\n   ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/CompletionController.java",
    "groupTitle": "Completion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryCompletionByDept"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryCompletion",
    "title": "查询流动资金占用成本管控目标完成情况分析",
    "name": "queryCompletion_____________________",
    "group": "Completion",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资金占用成本管控目标完成情况分析reportId值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryCompletion?year= &month= &reportId=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"查询流动资金占用成本管控目标完成情况成功\",\n  \"data\": [\n    {\n      \"planMonthTargetValue\": 47638.88,\n      \"planTotalReduceValue\": 142916.63,\n      \"actualMonthTargetValue\": 476,\n      \"actualTotalReduceValue\": 183963,\n      \"totalDifference\": 41046.37,\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      },\n      \"itemDept\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ]\n    }\n   ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/CompletionController.java",
    "groupTitle": "Completion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryCompletion"
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
            "field": "item_id",
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
          "content": "{\n \"item_id\":1,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /improvementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\n\"data\":[\n         {\n             \"id\":1,\n             \"item_id\":1,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                      \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n             },\n         {\n             \"id\":2,\n             \"item_id\":1,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n           }\n      ]}",
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
    "url": "/improvementPlan?year=&&month=",
    "title": "查询指定提升和改善计划表信息",
    "name": "selectImprovementPlanByDate_______________",
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
          "content": "GET: /improvementPlan?year=2018 && month = 2\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定提升和改善计划表成功\",\n\"data\":\n{\n{\n\"id\":1,\n\"item_id\":1,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"\n\"item\":{\n         \"id\":\"1001\"\n         \"item_code\"=\"短期投资\"\n         \"item_name\"=\"短期投资\"\n         \"calc_expr=\"1101-1102\"\n         \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n         \"state\"=\"1\"\n         \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n \"employee\":{\n         \"id\":\"450\"\n         \"employee_code\"=\"14\"\n         \"simple_code\"=\"G01\"\n         \"employee_name\"=\"林*香\"\n         \"employee_type\"=\"\"\n         \"dept_code\"=\"C301\"\n          \"state\"=\"1\"\n          \"modify_time\"=\"2019-04-11 19:10:00\"\n }\n \"department\":{\n     \"id\":\"2\"\n     dept_code:\"BIZ01\"\n     dept_name:\"大客户业务\"\n     parent_dept_code:\"CO001\"\n     liable_employee:\"\"\n     level=\"2\"\n     state=\"1\"\n     modify_time=\"2019-04-12 09:06:53\"\n }\n}\n{\n\"id\":2,\n\"item_id\":1,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"\n\"item\":{\n         \"item_code\"=\"短期投资\"\n         \"item_name\"=\"短期投资\"\n         \"calc_expr=\"1101-1102\"\n         \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n         \"state\"=\"1\"\n         \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n \"employee\":{\n         \"id\":\"450\"\n         \"employee_code\"=\"14\"\n         \"simple_code\"=\"G01\"\n         \"employee_name\"=\"林*香\"\n         \"employee_type\"=\"\"\n         \"dept_code\"=\"C301\"\n          \"state\"=\"1\"\n          \"modify_time\"=\"2019-04-11 19:10:00\"\n }\n \"department\":{\n     \"id\":\"2\"\n     dept_code:\"BIZ01\"\n     dept_name:\"大客户业务\"\n     parent_dept_code:\"CO001\"\n     liable_employee:\"\"\n     level=\"2\"\n     state=\"1\"\n     modify_time=\"2019-04-12 09:06:53\"\n }\n}\n}\n\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/improvementPlan?year=&&month="
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
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n }\nPOST: /improvementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
            "field": "interestRate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentiveRatio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "maxLimit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"interestRate\":0.55,\n         \"incentiveRatio\":0.55,\n         \"maxLimit\":0.55\n}\nPOST: /incentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询所有部门奖励比例成功\",\n\"data\":[\n     {\n         \"id\":200,\n         \"year\":\"2018\",\n         \"interestRate\":10.01,\n         \"incentiveRatio\":12.01,\n         \"maxLimit\":15.02,\n         \"createDate\":2019-05-09T13:14:48.000+0000\n     },\n     {\n         \"id\":201,\n         \"year\":\"2018\",\n         \"interestRate\":12.55,\n         \"incentiveRatio\":14,\n         \"maxLimit\":18.1,\n         \"createDate\":2019-05-09T13:15:01.000+0000\n     }\n])",
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
          "content": "GET: /incentiveRatio?id=201\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询指定部门奖励比例成功\",\n\"data\":{\n         \"id\":201,\n         \"year\":\"2018\",\n         \"interestRate\":12.55,\n         \"incentiveRatio\":14,\n         \"maxLimit\":18.1,\n         \"createDate\":2019-05-09T13:15:01.000+0000\n     }",
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
            "field": "interestRate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentiveRatio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "maxLimit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"id\":201,\n         \"year\":\"2019\",\n         \"interestRate\":35.03,\n         \"incentiveRatio\":35.03,\n         \"maxLimit\":35.03\n}\nPUT: /incentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
            "field": "interestRate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentiveRatio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "maxLimit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n     {\n         \"id\":201,\n         \"year\":\"2019\",\n         \"interestRate\":35.04,\n         \"incentiveRatio\":35.04,\n         \"maxLimit\":35.04\n     },\n     {\n         \"id\":202,\n         \"year\":\"2019\",\n         \"interestRate\":45.04,\n         \"incentiveRatio\":45.04,\n         \"maxLimit\":45.04\n     }\n]\nPUT: /incentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
    "type": "GET",
    "url": "/queryIncrementalValueByDept",
    "title": "根据部门查询流动资金占用成本管控增创价值表",
    "name": "queryIncrementalValueByDept______________________",
    "group": "IncrementalValue",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资金占用成本管控增创价值表reportId值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deptCode",
            "description": "<p>指定流动资金占用成本管控增创价值表deptCode值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryIncrementalValueByDept?year= &month= &reportId= &deptCode=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"根据部门查询流动资金占用成本管控增创价值成功\",\n  \"data\": [\n    {\n      \"actualMonthTargetValue\": 233,\n      \"actualTotalReduceValue\": 6161,\n      \"monthIncrementalValue\": 0,\n      \"totalIncrementalValue\": 0,\n      \"itemDept\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      }\n    }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncrementalValueController.java",
    "groupTitle": "IncrementalValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryIncrementalValueByDept"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryIncrementalValue",
    "title": "查询流动资金占用成本管控增创价值表",
    "name": "queryIncrementalValue__________________",
    "group": "IncrementalValue",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资金占用成本管控增创价值表reportId值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryIncrementalValue?year= &month= &reportId=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"查询流动资金占用成本管控增创价值成功\",\n  \"data\": [\n    {\n      \"actualMonthTargetValue\": 476,\n      \"actualTotalReduceValue\": 183963,\n      \"monthIncrementalValue\": 5973.8,\n      \"totalIncrementalValue\": 2308735.65,\n      \"itemDept\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      }\n    }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncrementalValueController.java",
    "groupTitle": "IncrementalValue",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryIncrementalValue"
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
            "field": "item_id",
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
          "content": "{\n\"item_id\":1,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":80,\n\"measure\":\"1\",\n\"experience\":\"1\",\n\"deficiency\":\"1\",\n\"evaluate\":\"1\",\n\"remark\":\"1\"\n}\nPUT /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询所有流动资金成本管控情况月度总结情况报告表成功\",\"data\":\n[\n    {\n     \"id\":1,\n     \"item_id\":1,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00-01\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     },\n    {\n     \"id\":2,\n     \"item_id\":1,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     }\n ]\n }",
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
    "url": "/monthReport?year=&&month=",
    "title": "查询指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "selectMonthReportByDate__________________________",
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
          "content": "GET: /monthReport?year= 2019 && month = 5\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定流动资金成本管控情况月度总结情况报告表成功\",\n\"data\":\n{\n{\n     \"id\":1,\n     \"index\":0,\n     \"item_id\":1,\n     \"year\":\"2019\",\n     \"month\":\"5\",\n     \"ok\":1,\n     \"plan\":\"1\",\n     \"remark\":\"1\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n     \"item_name\":\"短期投资\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n      \"responsibleDepartments\":{\n          \"deptCode\"=\"C500\"\n          \"deptName\"=\"战略客户部公共\"\n      }\n      \"responsibleEmployee\":{\n          \"employeeName\"=\"陈*坤\"\n          \"id\"=\"456\"\n      }\n      \"collaborativeDepartments\":{\n          \"deptCode\":\"B101\"\n          \"deptName\":\"桌面产品营销处\"\n      }\n      \"collaborativeEmployee\":{\n          \"employeeName\"=\"袁*娟\"\n          \"id\"=\"455\"\n      }\n   }\n{\n     \"id\":2,\n     \"index:1,\n     \"item_id\":1,\n     \"year\":\"2019\",\n     \"month\":\"5\",\n     \"ok\":1,\n     \"plan\":\"1\",\n     \"remark\":\"1\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n     \"item_name\":\"短期投资\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n      \"responsibleDepartments\":{\n          \"deptCode\"=\"C500\"\n          \"deptName\"=\"战略客户部公共\"\n      }\n      \"responsibleEmployee\":{\n          \"employeeName\"=\"陈*坤\"\n          \"id\"=\"456\"\n      }\n      \"collaborativeDepartments\":{\n          \"deptCode\":\"B101\"\n          \"deptName\":\"桌面产品营销处\"\n      }\n      \"collaborativeEmployee\":{\n          \"employeeName\"=\"袁*娟\"\n          \"id\"=\"455\"\n      }\n   }\n}\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/monthReport?year=&&month="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/calculateProportionAndReport?year=year&&month=month&&type=type",
    "title": "计算指定项目占比（旧的，暂时不用）",
    "name": "calculateProportionAndReport_________",
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
            "type": "int",
            "optional": false,
            "field": "type",
            "description": "<p>查询指定项目占比（资产和负债）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "删掉数据库本月的所有记录并且重新生成、写入数据库中\nGET: /calculateProportionAndReport?year=year&&month=month&&type=type\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"计算项目占比表成功,请查询\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/calculateProportionAndReport?year=year&&month=month&&type=type"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/calculateProportion",
    "title": "生成某部门某年月某类型项目占比表",
    "name": "calculateProportion________",
    "group": "Proportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /calculateProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"生成项目占比表成功（含部门信息）,请查询\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/calculateProportion"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllDepartment",
    "title": "获取所有的部门名称",
    "name": "getAllDepartment__________",
    "group": "Proportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllDepartment\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"获取所有的部门名称成功,请查询\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllDepartment"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/isCalculateProportion?year=year&&month=month&&type=type",
    "title": "判断是否计算",
    "name": "isCalculateProportion___________",
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
            "type": "int",
            "optional": false,
            "field": "type",
            "description": "<p>查询指定项目占比（资产和负债）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "如果已经计算，返回所有的信息。没有计算，提示用户进行计算\nGET: /isCalculateProportion?year=year&&month=month&&type=type\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"本月已经计算\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/isCalculateProportion?year=year&&month=month&&type=type"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionAndReport?year=year&&month=month&&type=type",
    "title": "查询指定项目占比",
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
            "type": "int",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定报表的Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
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
    "title": "根据id查询指定项目占比",
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
    "url": "/selectProportion",
    "title": "查询某部门某年月某类型项目占比表信息",
    "name": "selectProportion________",
    "group": "Proportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询项目占比表成功（含部门信息）\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportion"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/reduceTargets",
    "title": "删——删除所有项目降低目标设置",
    "name": "deleteAllReduceTargets________________",
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
    "title": "删——删除指定项目降低目标设置",
    "name": "deleteReduceTarget________________",
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
    "type": "DELETE",
    "url": "/reduceTargets_year?year=type=",
    "title": "删——根据年份删除项目降低目标设置（流动资产或流动负债）",
    "name": "deleteReduceTarget_____________________________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "type",
            "description": "<p>1:流动资产 2;流动负债</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /reduceTargets_year?year=2019?type=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"根据年份删除流动资产（流动负债）项目降低目标设置\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_year?year=type="
      }
    ]
  },
  {
    "type": "POST",
    "url": "/reduceTargets",
    "title": "增——添加项目降低目标设置",
    "name": "insertReduceTargets______________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "item_id",
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
          "content": "[\n     {\"item_id\":1003,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1004,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1005,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1006,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1007,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1008,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1009,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1010,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1011,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1012,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1013,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1014,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1},\n     {\"item_id\":1015,\"year\":\"2019\",\"year_percent\":90,\"asset_or_debt\":1}\n]\nPOST: /reduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加项目降低目标设置成功\",\"data\":true}",
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
    "url": "/reduceTargets",
    "title": "查——查询所有项目降低目标设置",
    "name": "queryAllReduceTargets________________",
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
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询所有项目降低目标设置成功\",\"data\":[\n        {\"id\":208,\n         \"item_id\":1003,\n         \"year\":\"2018\",\n         \"year_percent\":60,\n         \"year_value\":72.0000,\n         \"last_year_value\":120,\n         \"jan\":5,\n         \"feb\":5,\n         \"mar\":5,\n         \"apr\":5,\n         \"may\":5,\n         \"jun\":5,\n         \"jul\":5,\n         \"aug\":5,\n         \"sept\":5,\n         \"oct\":5,\n         \"nov\":5,\n         \"dec\":5,\n         \"asset_or_debt\":true,\n         \"create_date\":2019-06-01T05:13:02.000+0000\n         \"item_name\"=\"货币资金\",\n         \"item\":{\n             \"item_code\"=\"货币资金\",\n             \"item_name\"=\"货币资金\",\n             \"calc_expr\"=\"$1001+$1002+$1009\",\n             \"calc_explain\"=\"现金+银行存款+其他货币资金\",\n             \"state\"=\"1\",\n             \"modify_time\"= 2019-04-28T01:54:33.000+0000\n         }\n       },\n       .\n       .\n       .\n{\"id\":233,\n         \"item_id\":2015,\n         \"year\":\"2018\",\n         \"year_percent\":50,\n         \"year_value\":60.0000,\n         \"last_year_value\":120,\n         \"jan\":4.1667,\n         \"feb\":4.1667,\n         \"mar\":4.1667,\n         \"apr\":4.1667,\n         \"may\":4.1667,\n         \"jun\":4.1667,\n         \"jul\":4.1667,\n         \"aug\":4.1667,\n         \"sept\":4.1667,\n         \"oct\":4.1667,\n         \"nov\":4.1667,\n         \"dec\":4.1663,\n         \"asset_or_debt\":true\n         \"create_date\":2019-06-01T06:39:58.000+0000\n         \"item_name\"=\"其他流动负债\",\n         \"item\":{\n             \"item_code\"=\"其他流动负债\",\n             \"item_name\"=\"其他流动负债\",\n             \"calc_expr=\"0\",\n             \"calc_explain\"=\"\",\n             \"state\"=\"1\",\n             \"modify_time\"=2019-05-06T09:31:40.000+0000\n         }\n       }\n}",
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
    "url": "/items?type=",
    "title": "查——查询流动资产（或流动负债）条目",
    "name": "queryItemsByType___________________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "type",
            "description": "<p>1:流动资产 2;流动负债</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /items?type=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询流动资产（或流动负债）条目成功\",\"data\":[\n\"data\":{\n         \"id\":1003,\n         \"item_code\"=\"货币资金\",\n         \"item_name\"=\"货币资金\",\n         \"calc_expr\"=\"$1001+$1002+$1009\",\n         \"calc_explain\"=\"现金+银行存款+其他货币资金\",\n         \"state\"=\"1\",\n         \"modify_time\"= 2019-04-28T01:54:33.000+0000\n       },\n       .\n       .\n       .\n\"data\":{\n         \"id\":1015,\n         \"item_code\"=\"待摊费用\",\n         \"item_name\"=\"待摊费用\",\n         \"calc_expr=\"$1301\",\n         \"calc_explain\"=\"待摊费用\",\n         \"state\"=\"1\",\n         \"modify_time\"=2019-05-06T02:43:09.000+0000\n       }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/items?type="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/reduceTargets_child?id=id",
    "title": "查——查询子部门月降低目标（新）",
    "name": "queryReduceTargetByDepartmentAndItem______________",
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
          "content": "GET: /reduceTargets_child?19268\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询成功，返回父部门及子部门记录\",\"data\":[\n        {\"id\":19268,\n         \"item_id\":1004,\n         \"year\":\"2019\",\n         \"dept_code\":\"CO001\",\n         \"dept_name\":\"四美达\"\n         \"year_percent\":50,\n         \"year_value\":75310.4,\n         \"last_year_value\":188276,\n         \"jan\":3.3333，\n         \"feb\":3.3333，\n         \"mar\":3.3333，\n         \"apr\":3.3333，\n         \"may\":3.3333，\n         \"jun\":3.3333，\n         \"jul\":3.3333，\n         \"aug\":3.3333，\n         \"sept\":3.3333，\n         \"oct\":3.3333，\n         \"nov\":3.3333，\n         \"dec\":3.3337，\n         \"cnaModify\"=False    false表示不可修改    true可修改\n         \"asset_or_debt\":0,\n         \"create_date\":2019-06-21T12:16:52.000+0000\n         \"item_name\"=\"短期投资\",\n         \"item\":{\n             \"item_code\"=\"短期投资\",\n             \"item_name\"=\"短期投资\",\n             \"calc_expr\"=\"$1101-$1102\",\n             \"calc_explain\"=\"短期投资-短期投资跌价准备\",\n             \"state\"=\"1\",\n             \"modify_time\"= 2019-04-28T01:59:55.000+0000\n         }\n       },\n       .\n       .\n       .\n{\"id\":19424,\n         \"item_id\":1004,\n         \"year\":\"2019\",\n         \"dept_code\":\"BIZ01\",\n         \"dept_name\":\"其他\"\n         \"year_percent\":0,\n         \"year_value\":0,\n         \"last_year_value\":188962,\n         \"jan\":0.5555，\n         \"feb\":0.5555，\n         \"mar\":0.5555，\n         \"apr\":0.5555，\n         \"may\":0.5555，\n         \"jun\":0.5555，\n         \"jul\":0.5555，\n         \"aug\":0.5555，\n         \"sept\":0.5555，\n         \"oct\":0.5555，\n         \"nov\":0.5555，\n         \"dec\":0.5556，\n         \"asset_or_debt\":0\n         \"create_date\":2019-06-21T12:16:53.000+0000\n       }\n}\n<p>",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"没有下级部门记录\",\"data\":null}\n<p>",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"输入id有误\",\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_child?id=id"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/reduceTargets_year_type?year=year&type=type",
    "title": "查——根据年份查询项目降低目标（流动资产或流动负债）",
    "name": "reduceTargets_year_type___________________________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "type",
            "description": "<p>1:流动资产 2;流动负债</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /reduceTargets_year_type?year=2019&type=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"根据年份查询项目降低目标成功\",\"data\":[\n        {\"id\":19267,\n         \"item_id\":1003,\n         \"year\":\"2019\",\n         \"dept_code\":\"CO001\",\n         \"dept_name\":\"四美达\"\n         \"year_percent\":0,\n         \"year_value\":0,\n         \"last_year_value\":188274,\n         \"jan\":0,\n         \"feb\":0,\n         \"mar\":0,\n         \"apr\":0,\n         \"may\":0,\n         \"jun\":0,\n         \"jul\":0,\n         \"aug\":0,\n         \"sept\":0,\n         \"oct\":0,\n         \"nov\":0,\n         \"dec\":0,\n         \"cnaModify\"=False    false表示不可修改    true可修改\n         \"asset_or_debt\":0,\n         \"create_date\":2019-06-01T05:13:02.000+0000\n         \"item_name\"=\"货币资金\",\n         \"item\":{\n             \"item_code\"=\"货币资金\",\n             \"item_name\"=\"货币资金\",\n             \"calc_expr\"=\"$1001+$1002+$1009\",\n             \"calc_explain\"=\"现金+银行存款+其他货币资金\",\n             \"state\"=\"1\",\n             \"modify_time\"= 2019-04-28T01:54:33.000+0000\n         }\n       },\n       .\n       .\n       .\n{\"id\":19279,\n         \"item_id\":1015,\n         \"year\":\"2019\",\n         \"dept_code\":\"CO001\",\n         \"dept_name\":\"四美达\"\n         \"year_percent\":0,\n         \"year_value\":0,\n         \"last_year_value\":188298,\n         \"jan\":0，\n         \"feb\":0，\n         \"mar\":0，\n         \"apr\":0，\n         \"may\":0，\n         \"jun\":0，\n         \"jul\":0，\n         \"aug\":0，\n         \"sept\":0，\n         \"oct\":0，\n         \"nov\":0，\n         \"dec\":0，\n         \"asset_or_debt\":0,\n         \"create_date\":2019-05-06T02:43:09.000+0000\n         \"item_name\"=\"待摊费用\",\n         \"item\":{\n             \"item_code\"=\"待摊费用\",\n             \"item_name\"=\"待摊费用\",\n             \"calc_expr=\"$1301\",\n             \"calc_explain\"=\"待摊费用\",\n             \"state\"=\"1\",\n             \"modify_time\"=2019-05-06T02:43:09.000+0000\n         }\n       }\n}\n<p>",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"没有数据\",\"data\":null}\n<p>",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"没有数据\",\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_year_type?year=year&type=type"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTarget_child",
    "title": "改——更改子部门月降低目标（新）",
    "name": "updateMonthByDepartmentAndItem______________",
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
            "field": "jan",
            "description": "<p>一月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "feb",
            "description": "<p>二月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "mar",
            "description": "<p>三月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "apr",
            "description": "<p>四月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "may",
            "description": "<p>五月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "jun",
            "description": "<p>六月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "jul",
            "description": "<p>七月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "aug",
            "description": "<p>八月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "sept",
            "description": "<p>九月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "oct",
            "description": "<p>十月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "nov",
            "description": "<p>十一月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "dec",
            "description": "<p>十二月份</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n         {\n\t            \"id\":19268\n         },\n         {\n\t          \"id\":19294,\n\t          \"jan\":0.5559,\n           \"feb\":0.5559,\n            \"mar\":0.5559,\n            \"apr\":0.5559,\n            \"may\":0.5559,\n            \"jun\":0.5559,\n            \"jul\":0.5559,\n            \"aug\":0.5559,\n            \"sept\":0.5559,\n            \"oct\":0.5559,\n            \"nov\":0.5559,\n            \"dec\":0.5558\n     },\n     {\n\t            \"id\":19320,\n\t            \"jan\":0.5554,\n            \"feb\":0.5554,\n            \"mar\":0.5554,\n            \"apr\":0.5554,\n            \"may\":0.5554,\n            \"jun\":0.5554,\n            \"jul\":0.5554,\n            \"aug\":0.5554,\n            \"sept\":0.5554,\n            \"oct\":0.5554,\n            \"nov\":0.5554,\n            \"dec\":0.5555\n     },\n     {\n\t            \"id\":19346,\n\t            \"jan\":0.5556,\n            \"feb\":0.5556,\n            \"mar\":0.5556,\n            \"apr\":0.5556,\n            \"may\":0.5556,\n            \"jun\":0.5556,\n            \"jul\":0.5556,\n            \"aug\":0.5556,\n            \"sept\":0.5556,\n            \"oct\":0.5556,\n            \"nov\":0.5556,\n            \"dec\":0.5557\n     },\n     {\n         \t\"id\":19372,\n\t            \"jan\":0.5554,\n            \"feb\":0.5554,\n            \"mar\":0.5554,\n            \"apr\":0.5554,\n            \"may\":0.5554,\n            \"jun\":0.5554,\n            \"jul\":0.5554,\n            \"aug\":0.5554,\n            \"sept\":0.5554,\n            \"oct\":0.5554,\n            \"nov\":0.5554,\n            \"dec\":0.5555\n     },\n     {\n\t            \"id\":19398,\n\t            \"jan\":0.5556,\n            \"feb\":0.5556,\n            \"mar\":0.5556,\n            \"apr\":0.5556,\n            \"may\":0.5556,\n            \"jun\":0.5556,\n            \"jul\":0.5556,\n            \"aug\":0.5556,\n            \"sept\":0.5556,\n            \"oct\":0.5556,\n            \"nov\":0.5556,\n            \"dec\":0.5557\n     },\n     {\n         \t\"id\":19424,\n\t            \"jan\":0.5554,\n            \"feb\":0.5554,\n            \"mar\":0.5554,\n            \"apr\":0.5554,\n            \"may\":0.5554,\n            \"jun\":0.5554,\n            \"jul\":0.5554,\n            \"aug\":0.5554,\n            \"sept\":0.5554,\n            \"oct\":0.5554,\n            \"nov\":0.5554,\n            \"dec\":0.5555\n     }\n]\nPUT: /reduceTargets_yearPercent\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改子部门月降低目标成功\",\"data\":1}\n<p>",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"不存在\",\"data\":-2}\n<p>",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"修改失败,总和不相等\",\"data\":-1}\n<p>",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改子部门月降低目标成功\",\"data\":0}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTarget_child"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTargets_monthValue",
    "title": "改——批量更改项目月降低目标",
    "name": "updateReduceTargets_monthValue_______________",
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
            "field": "jan",
            "description": "<p>一月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "feb",
            "description": "<p>二月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "mar",
            "description": "<p>三月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "apr",
            "description": "<p>四月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "may",
            "description": "<p>五月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "jun",
            "description": "<p>六月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "jul",
            "description": "<p>七月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "aug",
            "description": "<p>八月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "sept",
            "description": "<p>九月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "oct",
            "description": "<p>十月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "nov",
            "description": "<p>十一月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "dec",
            "description": "<p>十二月份</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n           {\n            \"id\":19268,\n            \"jan\":3.3330,\n            \"feb\":3.3331,\n            \"mar\":3.3332,\n            \"apr\":3.3333,\n            \"may\":3.3334,\n            \"jun\":3.3335,\n            \"jul\":3.3336,\n            \"aug\":3.3337,\n            \"sept\":3.3338,\n            \"oct\":3.3339,\n            \"nov\":3.3330,\n            \"dec\":3.3325\n            },\n           {\n            \"id\":19269,\n            \"jan\":3.3331,\n            \"feb\":3.3330,\n            \"mar\":3.3332,\n            \"apr\":3.3333,\n            \"may\":3.3334,\n            \"jun\":3.3335,\n            \"jul\":3.3336,\n            \"aug\":3.3337,\n            \"sept\":3.3338,\n            \"oct\":3.3339,\n            \"nov\":3.3330,\n            \"dec\":3.3325\n            }\n      ]\nPUT: /reduceTargets_monthValue\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更改项目月降低目标\",\"data\":1}\n<p>",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"只允许修改今年的项目月降低目标\",\"data\":0}\n<p>",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"总合不等于year_percent\",\"data\":-1}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_monthValue"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/reduceTargets_yearPercent",
    "title": "改——批量更改项目年降低目标",
    "name": "updateReduceTargets_yearPercent_______________",
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
            "type": "Double",
            "optional": false,
            "field": "year_percent",
            "description": "<p>年度百分比，单位%</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "      [\n           {\"id\":19267,\"year_percent\":50},\n           {\"id\":19268,\"year_percent\":40},\n           {\"id\":19269,\"year_percent\":40},\n           {\"id\":19270,\"year_percent\":40},\n           {\"id\":19271,\"year_percent\":40},\n           {\"id\":19272,\"year_percent\":40},\n           {\"id\":19273,\"year_percent\":40},\n           {\"id\":19274,\"year_percent\":40},\n           {\"id\":19275,\"year_percent\":40},\n           {\"id\":19276,\"year_percent\":40},\n           {\"id\":19277,\"year_percent\":40},\n           {\"id\":19278,\"year_percent\":40},\n           {\"id\":19279,\"year_percent\":40}\n      ]\nPUT: /reduceTargets_yearPercent\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改项目年降低目标比例成功\",\"data\":true}\n<p>",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改项目年降低目标比例失败\",\"data\":false}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/reduceTargets_yearPercent"
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
    "url": "/queryResponsibilityIndicatorByDept",
    "title": "根据部门查询流动资金占用成本管控责任关键指标",
    "name": "queryResponsibilityIndicatorByDept_______________________",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定动资金占用成本管控责任关键指标表reportId值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deptCode",
            "description": "<p>指定动资金占用成本管控责任关键指标表deptCode值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryResponsibilityIndicatorByDept?year= &month= &reportId= &deptCode=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"根据部门查询流动资金占用成本管控责任指标成功\",\n  \"data\": [\n    {\n      \"lastMonthBalance\": 15742,\n      \"planMonthTargetValue\": 47638.88,\n      \"itemEmployee\": null,\n      \"itemDepts\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        },\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 0,\n          \"deptCode\": \"B101\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"B101\",\n            \"deptName\": \"桌面产品营销处\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"itemEmployees\": [\n        {\n          \"id\": 1,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"employeeId\": 456,\n          \"employee\": {\n            \"id\": 456,\n            \"employeeCode\": null,\n            \"simpleCode\": null,\n            \"employeeName\": \"陈*坤\",\n            \"employeeType\": null,\n            \"deptCode\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      }\n    }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ResponsibilityIndicatorController.java",
    "groupTitle": "ResponsibilityIndicator",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryResponsibilityIndicatorByDept"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryResponsibilityIndicator",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定动资金占用成本管控责任关键指标表reportId值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryResponsibilityIndicator？year= &month= &reportId=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"查询流动资金占用成本管控责任指标成功\",\n  \"data\": [\n    {\n      \"lastMonthBalance\": 622549,\n      \"planMonthTargetValue\": 47638.88,\n      \"itemEmployee\": null,\n      \"itemDepts\": [\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"deptCode\": \"C500\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"C500\",\n            \"deptName\": \"战略客户部公共\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        },\n        {\n          \"id\": null,\n          \"itemId\": 1001,\n          \"isCharge\": 0,\n          \"deptCode\": \"BIZ06\",\n          \"department\": {\n            \"id\": null,\n            \"deptCode\": \"BIZ06\",\n            \"deptName\": \"其他\",\n            \"parentDeptCode\": null,\n            \"level\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"itemEmployees\": [\n        {\n          \"id\": 1,\n          \"itemId\": 1001,\n          \"isCharge\": 1,\n          \"employeeId\": 449,\n          \"employee\": {\n            \"id\": 449,\n            \"employeeCode\": null,\n            \"simpleCode\": null,\n            \"employeeName\": \"-*-\",\n            \"employeeType\": null,\n            \"deptCode\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"资产\",\n        \"item_name\": \"资产\",\n        \"calc_expr\": \"\",\n        \"calc_explain\": \"\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1001\n      }\n    }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ResponsibilityIndicatorController.java",
    "groupTitle": "ResponsibilityIndicator",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryResponsibilityIndicator"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryTargetMatchingByDept",
    "title": "根据部门查询流动资产与流动负债目标匹配表",
    "name": "queryTargetMatchingByDept_____________________",
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资产与流动负债目标匹配表reportId值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deptCode",
            "description": "<p>指定流动资产与流动负债目标匹配表deptCode值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryTargetMatchingByDept?year= &month= &reportId= &deptCode=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{{\n  \"code\": 0,\n  \"message\": \"根据部门查询流动资金占用成本管控责任指标成功\",\n  \"data\": [\n    {\n      \"parentItemCode\": \"流动资产\",\n      \"lastMonthBalance\": 15744,\n      \"planMonthTargetValue\": 42875.03,\n      \"itemEmployee\": [\n        {\n          \"id\": 5,\n          \"itemId\": 1003,\n          \"isCharge\": 1,\n          \"employeeId\": 453,\n          \"employee\": {\n            \"id\": 453,\n            \"employeeCode\": null,\n            \"simpleCode\": null,\n            \"employeeName\": \"郭*芸\",\n            \"employeeType\": null,\n            \"deptCode\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"货币资金\",\n        \"item_name\": \"货币资金\",\n        \"calc_expr\": \"$1001+$1002+$1009\",\n        \"calc_explain\": \"现金+银行存款+其他货币资金\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1003\n      }\n    }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/TargetMatchingController.java",
    "groupTitle": "TargetMatching",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryTargetMatchingByDept"
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
          },
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "reportId",
            "description": "<p>指定流动资产与流动负债目标匹配表reportId值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryTargetMatching?year= &month= &reportId=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"code\": 0,\n  \"message\": \"查询流动资金占用成本管控责任指标成功\",\n  \"data\": [\n    {\n      \"parentItemCode\": \"流动资产\",\n      \"lastMonthBalance\": 15744,\n      \"planMonthTargetValue\": 42875.03,\n      \"itemEmployee\": [\n        {\n          \"id\": 5,\n          \"itemId\": 1003,\n          \"isCharge\": 1,\n          \"employeeId\": 453,\n          \"employee\": {\n            \"id\": 453,\n            \"employeeCode\": null,\n            \"simpleCode\": null,\n            \"employeeName\": \"郭*芸\",\n            \"employeeType\": null,\n            \"deptCode\": null,\n            \"state\": null,\n            \"modifyTime\": null\n          }\n        }\n      ],\n      \"item\": {\n        \"item_code\": \"货币资金\",\n        \"item_name\": \"货币资金\",\n        \"calc_expr\": \"$1001+$1002+$1009\",\n        \"calc_explain\": \"现金+银行存款+其他货币资金\",\n        \"state\": \"1\",\n        \"modify_date\": \"2019-04-28T01:54:33.000+0000\",\n        \"id\": 1003\n      }\n    ]\n}",
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
