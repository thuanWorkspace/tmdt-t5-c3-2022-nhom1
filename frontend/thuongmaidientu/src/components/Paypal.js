import React, { useRef, useEffect ,useLocation} from "react";
import { useParams } from "react-router-dom";

export default function Paypal() {
  const paypal = useRef();
  const { price } = useParams();
  // const { state } = useLocation();
  // const { price } = state || {};

  useEffect(() => {
    console.log('price',price)
    window.paypal
      .Buttons({
        createOrder: (data, actions, err) => {
          return actions.order.create({
            intent: "CAPTURE",
            purchase_units: [
              {
                description: "Cool looking table",
                amount: {
                  currency_code: "USD",
                  value: price,
                },
              },
            ],
          });
        },
        onApprove: async (data, actions) => {
          const order = await actions.order.capture();
          console.log(order);
        },
        onError: (err) => {
          console.log(err);
        },
      })
      .render(paypal.current);
  }, []);

  return (
    <div>
      <div ref={paypal}></div>
    </div>
  );
}