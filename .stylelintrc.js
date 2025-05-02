module.exports = {
  extends: ["stylelint-config-standard"],
  plugins: ["stylelint-order"],
  rules: {
    "order/properties-order": [
      [
        { properties: ["position","top","right","bottom","left","z-index"] },
        { properties: ["display","width","height","margin","padding","border","box-sizing"] },
        { properties: ["font-family","font-size","font-weight","line-height","text-align","color"] },
        { properties: ["background","background-color","background-image","background-size","box-shadow","opacity"] },
        { properties: ["cursor","outline","transition","transform","animation"] }
      ],
      { unspecified: "bottomAlphabetical" }
    ]
  }
};
