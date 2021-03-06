define({ "api": [
  {
    "type": "post",
    "url": "/v1/id/expId",
    "title": "解析分布式id",
    "version": "1.0.0",
    "name": "expId",
    "group": "ID",
    "permission": [
      {
        "name": "admin"
      }
    ],
    "description": "<p>把id解析成ID对象</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>接口生成的id，必传。</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "请求例子:",
        "content": "http://localhost/v1/id/expId?id=352608540609069079",
        "type": "json"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "timeStamp",
            "description": "<p>时间戳。41位的时间序列</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "dataCenterId",
            "description": "<p>数据中心id</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "workerId",
            "description": "<p>节点机器id</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "sequence",
            "description": "<p>序列号</p>"
          }
        ]
      }
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoAccessRight",
            "description": "<p>认证不通过 //@apiError UserNotFound   The <code>id</code> of the User was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应例子:",
          "content": "HTTP/1.1 401 Not Authenticated\n{\n  \"error\": \"NoAccessRight\"\n}",
          "type": "json"
        }
      ]
    },
    "sampleRequest": [
      {
        "url": "http://localhost/v1/id/expId"
      }
    ],
    "filename": "src/main/java/service/sys/common/api/IdGenerateApi.java",
    "groupTitle": "ID"
  },
  {
    "type": "post",
    "url": "/v1/id/gen",
    "title": "生成分布式id",
    "version": "1.0.0",
    "name": "genId",
    "group": "ID",
    "permission": [
      {
        "name": "admin"
      }
    ],
    "description": "<p>通过数据中心id，机器id生成long型唯一id</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "dataCenterId",
            "description": "<p>数据中心id,0-31。</p>"
          },
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "workerId",
            "description": "<p>机器id，0-31。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "Request Headers\n    Content-Type:application/json\nbody:\n{\n  \"dataCenterId\": 0,\n  \"workerId:\" 0\n}",
          "type": "json"
        }
      ]
    },
    "examples": [
      {
        "title": "请求例子:",
        "content": "curl -i http://localhost/user/4711",
        "type": "json"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>生成的id</p>"
          }
        ]
      }
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoAccessRight",
            "description": "<p>认证不通过</p>"
          },
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "UserNotFound",
            "description": "<p>The <code>id</code> of the User was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应例子:",
          "content": "HTTP/1.1 401 Not Authenticated\n{\n  \"error\": \"NoAccessRight\"\n}",
          "type": "json"
        }
      ]
    },
    "sampleRequest": [
      {
        "url": "url"
      }
    ],
    "filename": "src/main/java/service/sys/common/api/IdGenerateApi.java",
    "groupTitle": "ID"
  }
] });
