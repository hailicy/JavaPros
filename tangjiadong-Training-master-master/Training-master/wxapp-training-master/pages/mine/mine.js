// getCurrentPage是获取当前页面的实例对象。
const app = getApp()
Page({

  data: {
    balance:0.00,
    score:0,
    username:"未登录",
    userInfo: {},
    userimg:"../../image/skd.jpg",
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    arrow:"../../image/0106arrow3x.png",

    // 1.菜单栏数据
    items: [{
        icon: '../../image/yuyue.png',
        text: '我的预约',
        url:'../example/order/order'
      },

      {
        icon: '../../image/shoucang.png',
        text: '我的收藏',
        url:'../example/collect/collect'
      },

      {
        icon: '../../image/yijan.png',
        text: '意见反馈',
        url:'../example/fdback/fdback'
      },

      {
        icon: '../../image/qiandao.png',
        text: '每日签到',
        url:"../example/sign/index"
      },

      {
        icon: '../../image/youhui.png',
        text: '优惠券',
        url:"../example/coupons/index"
      },
      {
        icon:'../../image/kefu.png',
        text: '联系我们',
        url:"../example/contact/index"
      }
    ],

  },
  gotopage: function (event) {
    wx.navigateTo({
      url: event.currentTarget.dataset.hi
    })
  },
  goAsset:function(){
    wx.navigateTo({
      url:"/pages/asset/index"
    })
  },
  goScore:function(){
    wx.navigateTo({
      url:"/pages/score/index"
    })
  },
  onLoad:function(options) {
    var username = getApp().globalData.username
    console.log(username)
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        username: app.globalData.username,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          username: app.globalData.username,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            username: app.globalData.username,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  //事件处理函数
  bindViewTap: function () {

    var that = this;
    wx.openSetting({
      success: function (res) { // 这里重新调用代码，比如这里的重新显示头像昵称
        res.authSetting = {
          "scope.userInfo": true,
        }
      },
      f
    })
  }
})